import axios from "@/apis/api"

// 获取云通信管理账户列表
export const getCommunicateAcount = params => {
    return axios.post(`/communicationAcount/page`, params);
};

// 新增
export const communicateAcountAdd = params => {
    return axios.post(`/communicationAcount/insert`, params);
};


