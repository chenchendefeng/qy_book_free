import axios from "@/apis/api"

// 获取商品详情
export const getGoodsDetail = params => {
    return axios.post(`/goods/getGoodsInfo`, params);
};

// 新增、更新商品
export const saveOrUpdateGoods = params => {
    return axios.post(`/goods/saveOrUpdate`, params);
};

// 获取商品列表
export const getGoods = params => {
    return axios.post(`/goods/pageListGoods`, params);
};

// 获取购买记录
export const getBuyRecords = params => {
    return axios.post(`/goodsOrder/pageListGoods`, params);
};