import axios from "@/apis/api"

// 获取用户列表
export const getUsers = params => {
    return axios.post(`/user`, params);
};

// 获取用户详情
export const getUserDetail = params => {
    return axios.post(`/user/detail`, params);
};

// 获取现金明细
export const getCashDetail = params => {
    return axios.post(`/user/detail`, params);
};

// 获取金豆明细
export const getBeanDetail = params => {
    return axios.post(`/user/detail`, params);
};

// 获取专区列表
export const getZoneList = params => {
    return axios.post(`/bookSubject/listByCondition`, params);
};


// 获取专区详情
export const getZoneDetail = params => {
    return axios.post(`/bookSubject/getBookSubjectDetail`, params);
};

// 新增、更新专区详情
export const saveOrUpdateZone = params => {
    return axios.post(`/bookSubject/saveOrUpdate`, params);
};

// 专区，根据bid查询书籍
export const queryBook = params => {
    return axios.post(`/bookSubject/queryBookByBid`, params);
};
