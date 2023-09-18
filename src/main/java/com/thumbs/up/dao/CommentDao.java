package com.thumbs.up.dao;

import com.thumbs.up.domain.CommentDto;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    int count(Integer bno) throws Exception;

    int deleteAll(Integer bno);

    int delete(Integer cno, String commenter) throws Exception;

    int insert(CommentDto dto) throws Exception;

    List<CommentDto> selectAll(Integer bno) throws Exception;

    CommentDto select(Integer cno) throws Exception;

    int update(CommentDto dto) throws Exception;

    List<CommentDto> selectPage(Map map) throws Exception;
}
