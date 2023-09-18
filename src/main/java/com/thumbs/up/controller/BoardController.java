package com.thumbs.up.controller;

import com.thumbs.up.domain.BoardDto;
import com.thumbs.up.domain.PageHandler;
import com.thumbs.up.domain.SearchCondition;
import com.thumbs.up.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @Value("${uploadPath}")
    private String uploadPath;

    @PostMapping("/modify")
    public String modify(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.modify(boardDto);   // insert

            if(rowCnt != 1)
                throw new Exception("Modify failed.");

            rattr.addFlashAttribute("msg", "MOD_OK");

            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("msg", "MOD_ERR");
            return "board";
        } // try-catch
    } // modify

    @PostMapping("/write")
    public String write(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.write(boardDto);   // insert

            if(rowCnt != 1)
                throw new Exception("Write failed.");

            rattr.addFlashAttribute("msg", "WRT_OK");

            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto);
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        } // try-catch
    } // write

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");
        return "board";     // 읽기와 쓰기에 사용. 쓰기에 사용할때는 mode = new
    } // write

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = boardService.remove(bno, writer);

            if(rowCnt != 1)
                throw new Exception("board remove error");

            rattr.addAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addAttribute("msg", "DEL_ERR");
        } // try-catch

        return "redirect:/board/list";
    } // remove

    @GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno);
            m.addAttribute(boardDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } // try-catch
        return "board";
    } // read


    @GetMapping("/list")
    public String list(SearchCondition sc, Model m , HttpServletRequest request) {
        if(!loginCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            int totalCnt = boardService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<BoardDto> list = boardService.getSearchResultPage(sc);

            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
//            m.addAttribute("page", sc.getPage());
//            m.addAttribute("pageSize", sc.getPageSize());
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        } // try-catch

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    } // list

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id")!=null;
    } // loginCheck
}