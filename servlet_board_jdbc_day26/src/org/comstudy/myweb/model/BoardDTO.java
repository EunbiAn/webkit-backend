package org.comstudy.myweb.model;

import java.util.Date;

public class BoardDTO {
    private Long seq;
    private String title;
    private String content;
    private Date writeDate = new Date();
    private String writer;
    private Long cnt;

    public BoardDTO() {
//        this.BoardDTO(0L,"","",new Date(),"",0L);
    }

    public BoardDTO(Long seq, String title, String content, Date writeDate, String writer, Long cnt) {
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
        this.writer = writer;
        this.cnt = cnt;
    }

    public Long getSeq() {
        return seq;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public String getWriter() {
        return writer;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "seq=" + seq +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writeDate=" + writeDate +
                ", writer='" + writer + '\'' +
                ", cnt=" + cnt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardDTO boardDTO = (BoardDTO) o;

        return seq != null ? seq.equals(boardDTO.seq) : boardDTO.seq == null;
    }

    @Override
    public int hashCode() {
        return seq != null ? seq.hashCode() : 0;
    }
}
