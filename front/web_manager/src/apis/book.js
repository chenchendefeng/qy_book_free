import axios from "@/apis/api"

// 获取书籍列表
export const getBooks = params => {
    return axios.post(`/bookInfoManage/bookList`, params);
};

// 获取书籍分类
export const getBookCategory = params => {
    return axios.post(`/bookInfoManage/listBookCategory`, params);
};

// 获取书籍详情
export const getBookDetail = params => {
    return axios.post(`/bookInfoManage/bookDetail`, params);
};

// 修改书籍信息
export const updateBookDetail = params => {
    return axios.post(`/bookInfoManage/updateInformation`, params);
};