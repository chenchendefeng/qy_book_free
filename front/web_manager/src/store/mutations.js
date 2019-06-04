export default {
    changeBook(state, books) {
        state.book = books.book;
        state.bookuid = books.uid;
    },
    changezhifu(state, zhifu) {
        state.zhifu = zhifu
    },
    changexiaofei(state, xiaofei) {
        state.xiaofei = xiaofei
    },
    changeyuedu(state, yuedu) {
        state.yuedu = yuedu
    },
    changetuisong(state, tui) {
        state.tuisong = tui.tuisong;
        state.tuiuid = tui.uid
    },
    rmove(state) {
        state.book = "first",
            state.bookuid = "",
            state.uid = "",
            state.zhifu = "",
            state.xiaofei = "",
            state.tuisong = "first"
    },
    rmoves(state) {
        state.book = "first",
            state.bookuid = "",
            state.uid = "",
            state.tuisong = "first"
    },
    rmove1(state) {
        state.book = "first",
            state.zhifu = "",
            state.tuisong = "first"
    },
    rmove2(state) {
        state.book = "first",
            state.xiaofei = "",
            state.tuisong = "first"
    },
}
