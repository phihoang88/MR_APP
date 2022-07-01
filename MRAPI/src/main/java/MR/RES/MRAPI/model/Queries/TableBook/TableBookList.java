package MR.RES.MRAPI.model.Queries.TableBook;

import java.util.Objects;

public class TableBookList {
    private Object bookId;
    private Object tableId;
    private Object tableNmVn;
    private Object tableNmEn;
    private Object tableNmJp;
    private Object tableAva;
    private Object guessNm;
    private Object guessPhone;
    private Object guessCount;
    private Object noteTx;
    private Object bookDate;
    private Object bookTimeFrom;
    private Object bookTimeTo;
    private Object isCancel;

    private Object isEnd;

    public TableBookList() {
    }

    public TableBookList(Object bookId, Object tableId, Object tableNmVn, Object tableNmEn, Object tableNmJp, Object tableAva, Object guessNm, Object guessPhone, Object guessCount, Object noteTx, Object bookDate, Object bookTimeFrom, Object bookTimeTo, Object isCancel, Object isEnd) {
        this.bookId = bookId;
        this.tableId = tableId;
        this.tableNmVn = tableNmVn;
        this.tableNmEn = tableNmEn;
        this.tableNmJp = tableNmJp;
        this.tableAva = tableAva;
        this.guessNm = guessNm;
        this.guessPhone = guessPhone;
        this.guessCount = guessCount;
        this.noteTx = noteTx;
        this.bookDate = bookDate;
        this.bookTimeFrom = bookTimeFrom;
        this.bookTimeTo = bookTimeTo;
        this.isCancel = isCancel;
        this.isEnd = isEnd;
    }

    public Object getBookId() {
        return bookId;
    }

    public void setBookId(Object bookId) {
        this.bookId = bookId;
    }

    public Object getTableId() {
        return tableId;
    }

    public void setTableId(Object tableId) {
        this.tableId = tableId;
    }

    public Object getTableNmVn() {
        return tableNmVn;
    }

    public void setTableNmVn(Object tableNmVn) {
        this.tableNmVn = tableNmVn;
    }

    public Object getTableNmEn() {
        return tableNmEn;
    }

    public void setTableNmEn(Object tableNmEn) {
        this.tableNmEn = tableNmEn;
    }

    public Object getTableNmJp() {
        return tableNmJp;
    }

    public void setTableNmJp(Object tableNmJp) {
        this.tableNmJp = tableNmJp;
    }

    public Object getTableAva() {
        return tableAva;
    }

    public void setTableAva(Object tableAva) {
        this.tableAva = tableAva;
    }

    public Object getGuessNm() {
        return guessNm;
    }

    public void setGuessNm(Object guessNm) {
        this.guessNm = guessNm;
    }

    public Object getGuessPhone() {
        return guessPhone;
    }

    public void setGuessPhone(Object guessPhone) {
        this.guessPhone = guessPhone;
    }

    public Object getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(Object guessCount) {
        this.guessCount = guessCount;
    }

    public Object getNoteTx() {
        return noteTx;
    }

    public void setNoteTx(Object noteTx) {
        this.noteTx = noteTx;
    }

    public Object getBookDate() {
        return bookDate;
    }

    public void setBookDate(Object bookDate) {
        this.bookDate = bookDate;
    }

    public Object getBookTimeFrom() {
        return bookTimeFrom;
    }

    public void setBookTimeFrom(Object bookTimeFrom) {
        this.bookTimeFrom = bookTimeFrom;
    }

    public Object getBookTimeTo() {
        return bookTimeTo;
    }

    public void setBookTimeTo(Object bookTimeTo) {
        this.bookTimeTo = bookTimeTo;
    }

    public Object getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Object isCancel) {
        this.isCancel = isCancel;
    }

    public Object getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Object isEnd) {
        this.isEnd = isEnd;
    }
}
