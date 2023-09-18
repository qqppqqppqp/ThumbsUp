package com.thumbs.up.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class CommentDto {

   private Integer cno;
   private Integer bno;
   private Integer pcno;
   private String comment;
   private String commenter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date reg_date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date up_date;

    public CommentDto() {}

    public CommentDto(Integer bno, Integer pcno, String comment, String commenter) {
        this.bno = bno;
        this.pcno = pcno;
        this.comment = comment;
        this.commenter = commenter;
    } // constructor


}
