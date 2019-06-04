import axios from "@/apis/api"

// 获取个人中心配置列表
export const getPersonals = params => {
    return axios.post(`/personalCenter/page`, params);
};

// 获取个人中心配置详情
export const getPersonalById = params => {
    return axios.post(`/personalCenter/get`, params);
};

// 新增个人中心配置
export const addPersonal = params => {
    return axios.post(`/personalCenter/insert`, params);
};

// 更新修改个人中心配置
export const updatePersonal = params => {
    return axios.post(`/personalCenter/update`, params);
};


