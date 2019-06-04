import axios from "@/apis/api"

// 查询福利列表
export const getWelfareList = params => {
    return axios.post(`/welfare/page`, params);
};

// 查询福利详情
export const getWelfareDetail = params => {
    return axios.post(`/welfare/getById`, params);
};

// 新增福利项
export const addWelfare = params => {
    return axios.post(`/welfare/insert`, params);
};

// 修改福利项
export const updateWelfare = params => {
    return axios.post(`/welfare/update`, params);
};