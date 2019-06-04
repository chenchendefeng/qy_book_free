import axios from "@/apis/api"

// 礼品列表
export const getGifts = params => {
    return axios.post(`/exchangeGoods/page`, params);
};
// 获取礼品详情
export const getGiftById = params => {
    return axios.post(`/exchangeGoods/getById`, params);
};

// 新增礼品
export const addGift = params => {
    return axios.post(`/exchangeGoods/add`, params);
};

// 更新礼品
export const updateGift = params => {
    return axios.post(`/exchangeGoods/update`, params);
};

// 礼品兑换记录
export const getExchangeRecords = params => {
    return axios.post(`/exchangeOrder/page`, params);
};

// 礼品兑换审核
export const exchangeAudit = params => {
    return axios.post(`/exchangeOrder/audit`, params);
};
