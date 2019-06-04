import axios from "@/apis/api"

// 获取用户列表
export const getUsers = params => {
    return axios.post(`/customer/pageListGoodsOrder`, params);
};

// 充值金豆、现金
export const userRecharge = params => {
    return axios.post(`/customer/recharge`, params);
};
// 获取账户详情
export const getAccountDetail = params => {
    return axios.post(`/customer/getCustomerAccountInfo`, params);
};

// 获取现金/金豆明细
export const getAccountFlow = params => {
    return axios.post(`/accountFlow/pageListAccountFlow`, params);
};


