import router from '../router/index'
import axios from 'axios';
import qs from 'qs';
import {
    Message
} from 'element-ui';

axios.defaults.withCredentials = true;

/* 请求拦截器 */
axios.interceptors.request.use((config) => {
    if (config.method === 'post') {
        config.headers['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
        config.transformRequest = [function (data, headers) {
            return qs.stringify(data ,{arrayFormat:'indices',allowDots:true});
        }];
    }
    return config;
}, (err) => {
    return Promise.reject(err);
});

//响应拦截器即异常处理
axios.interceptors.response.use(response => {
    if (response.data.result !== "success") {
        Message.error(response.data.msg);
        return false;
    }
    return response;
}, err => {
    // 请求的错误判断,根据不同的错误码不同消息提醒
    if (err && err.response) {
        switch (err.response.status) {
            case 302:
                router.push({
                    path: "/login"
                });
                err.message = "请重新登陆"
                break;
            case 400:
                err.message = '错误请求'
                break;
            case 401:
                router.push({
                    path: "/login"
                });
                err.message = '未授权，请重新登录'
                break;
            case 403:
                err.message = '拒绝访问'
                break;
            case 404:
                // router.push({
                //     path: "/login"
                // });
                err.message = '请求错误,未找到该资源'
                break;
            case 405:
                err.message = '请求方法未允许'
                break;
            case 408:
                err.message = '请求超时'
                break;
            case 500:
                err.message = '服务器端出错'
                break;
            case 501:
                err.message = '网络未实现'
                break;
            case 502:
                err.message = '网络错误'
                break;
            case 503:
                err.message = '服务不可用'
                break;
            case 504:
                err.message = '网络超时'
                break;
            case 505:
                err.message = 'http版本不支持该请求'
                break;
            default:
                err.message = `连接错误${err.response.status}`
        }
    } else {
        router.push({
            path: "/login"
        });
        err.message = "连接到服务器失败,请重新登陆"
    }
    Message.error(err.message)
    return Promise.resolve(err.response)
})


// let base='http://admin.qybook.net/admin'//测试

axios.defaults.baseURL = '/admin-free'

export default axios

//用户管理块
//登录
export const requestLogin = params => {
    return axios.post(`/login`, params);
};

//登出
export const requestlogout = params => {
    return axios.post(`/logo/${params}`);
};

//获取用户列表
export const getUserList = params => {
    return axios.post(`/admin/getUsers`, params);
};

//添加用户
export const getaddUser = params => {
    return axios.post(`/admin/addUser`, params);
};

//删除用户
export const deleteUsers = params => {
    return axios.post(`/admin/deleteUsers/${params}`);
};

//修改密码
export const updatePassword = params => {
    return axios.post(`/admin/updatePassword/${params.id}`, params);
};

//修改用户信息
export const updateUser = params => {
    return axios.post(`/admin/updateUser/${params.id}`, params);
};

//角色模块
//角色查询
export const roleList = params => {
    return axios.post(`/admin/roleList`, params);
};

//新增角色
export const addRole = params => {
    return axios.post(`/admin/addRole`, params);
};

//删除角色
export const deleteRole = params => {
    return axios.post(`/admin/deleteRole/${params}`);
};

//权限列表
export const permissionList = params => {
    return axios.post(`/admin/permissionList`, params);
};

//角色权限跟新
export const updateRole = params => {
    return axios.post(`/admin/updateRole/${params.id}`, params);
};

//角色详情
export const roleDetail = params => {
    return axios.post(`/admin/roleDetail/${params}`);
};

//订单管理查询
export const ManageorderList = params => {
    return axios.post(`/orderManager/orderList`, params);
};

//书币使用查询
export const consumeHistoryMgrlist = params => {
    return axios.post(`/consumeHistoryMgr/list`, params);
};

//用户查询
export const customerlist = params => {
    return axios.post(`/customer/list`, params);
};

//用户详情  
export const customeruserInfoDetail = params => {
    return axios.post(`/customer/userInfoDetail`, params);
};

//邀请管理查询
export const inviteRecordMgrlist = params => {
    return axios.post(`/inviteRecordMgr/list`, params);
};









//给用户充币
export const customeraddBookMoney = params => {
    return axios.post(`/customer/addBookMoney`, params);
};




//给用户冲畅读卡
export const addReadCard = params => {
    return axios.post(`/userPayManage/addReadCard/${params.uid}`, params);
};




// 渠道列表 
export const channellist = params => {
    return axios.get(`/channel/list`, {
        ...params
    });
};



// 统计

//订单统计

export const orderCountList = params => {
    return axios.post(`/orderCount/orderCountList`, params);
};

//订单分析
export const orderAnalysisList = params => {
    return axios.post(`/orderAnalysis/orderAnalysisList`, params);
};

//用户分析
export const registAnalysisList = params => {
    return axios.post(`/userRegist/registAnalysisList`, params);
};


//首次充值详细
export const userFirstPayList = params => {
    return axios.post(`/userPay/userFirstPayList`, params);
};

//首次注册详细
export const userFirstRegistList = params => {
    return axios.post(`/userRegist/userFirstRegistList`, params);
};

//用户来源统计
export const registResourceList = params => {
    return axios.post(`/userRegist/registResourceList`, params);
};

//用户留存统计
export const userAliveAnalysisList = params => {
    return axios.post(`/userRegist/userAliveAnalysisList`, params);
};

//用户活跃统计

export const active = params => {
    return axios.post(`/customerStatustics/active`, params);
};

//管理模块

//1.书籍管理
//书籍查询列表
export const bookList = params => {
    return axios.post('/bookInfoManage/bookList', params)
};

//书籍下架
export const bookOffShelf = params => {
    return axios.post('/bookInfoManage/bookOffShelf', params)
};

//书籍上架
export const bookUpShelf = params => {
    return axios.post('/bookInfoManage/bookUpShelf', params)
};


//书籍详情
export const bookDetail = params => {
    return axios.post('/bookInfoManage/bookDetail', params)
};

//书籍修改记录
export const bookUpdateRecord = params => {
    return axios.post('/bookInfoManage/bookUpdateRecord', params)
};

//修改收费模式
export const modifyBookPayType = params => {
    return axios.post('/bookInfoManage/modifyBookPayType', params)
};

//修改书籍单价
export const modifyBookUnitPrice = params => {
    return axios.post('/bookInfoManage/modifyBookUnitPrice', params)
};


//修改书籍封面
export const updateCoverUrl = params => {
    return axios.post('/bookInfoManage/updateCoverUrl', params)
};


//书籍售卖查询   
export const bookOrderMgrlist = params => {
    return axios.post('/bookOrderMgr/list', params)
};

//书籍阅读查询  
export const readingTimeMgrlist = params => {
    return axios.post('/readingTimeMgr/list', params)
};

//修改书架书籍
export const customerbookshelfList = params => {
    return axios.post('/customer/bookshelfList', params)
};

//删除书架书籍  
export const customerdeleteBookAtBookshelf = params => {
    return axios.post('/customer/deleteBookAtBookshelf', params)
};




//运营
//版本配置
export const verpage = params => {
    return axios.post('/versionManage/page', params)
};

//版本删除
export const versiondelete = params => {
    return axios.post('/versionManage/delete', params)
};

//版本添加
export const versioninsert = params => {
    return axios.post('/versionManage/insert', params)
};

//版本更新

export const versionupdate = params => {
    return axios.post('/versionManage/update', {
        ...params
    })
};


//弹窗列表
export const popupWindowManagerlist = params => {
    return axios.post('/popupWindow/page', {
        ...params
    })
};

//添加弹窗
export const popupWindowadd = params => {
    return axios.post('/popupWindow/add', {
        ...params
    })
};

//删除弹窗 
export const popupWindelete = params => {
    return axios.post(`/popupWindow/delete`, {
        ...params
    })
};

//跟新弹窗
export const popupWinupdate = params => {
    return axios.post(`/popupWindow/update`, {
        ...params
    })
};

// OSS文件删除
export const stOSSFile = params => {
    return axios.post(`/startPage/deleteOSSFile`, {
        ...params
    })
};


//首屏删除  
export const startPagedelete = params => {
    return axios.post(`/startPage/delete`, {
        ...params
    })
};

//保存或修改首屏 

export const startPaUpdate = params => {
    return axios.post(`/startPage/saveOrUpdate`, {
        ...params
    })
};

//首屏弹窗   
export const startPagelist = params => {
    return axios.post(`/startPage/list`, {
        ...params
    })
};



//关键词列表
export const searchWlist = params => {
    return axios.post(`/searchWord/list`, {
        ...params
    })
};

//关键词删除   
export const searchWdelete = params => {
    return axios.post(`/searchWord/delete`, {
        ...params
    })
};

//关键词创建   
export const searchWsaveOrUpdate = params => {
    return axios.post(`/searchWord/saveOrUpdate`, {
        ...params
    })
};


//商品列表  
export const goodsManagerlist = params => {
    return axios.post(`/goodsManager/list`, {
        ...params
    })
};

//商品删除  
export const goodsManagerdelete = params => {
    return axios.post(`/goodsManager/delete/${params.id}`, {
        ...params
    })
};

//商品添加或修改      
export const goodsManagUpdate = params => {
    return axios.post(`/goodsManager/saveOrUpdate`, {
        ...params
    })
};


//banner删除
export const bannerdelete = params => {
    return axios.post(`/banner/delete`, {
        ...params
    })
};

//banner列表
export const bannerlist = params => {
    return axios.post(`banner/list`, {
        ...params
    })
};

//新增或修改banner 
export const bannersaveOrUpdate = params => {
    return axios.post(`banner/saveOrUpdate`, {
        ...params
    })
};



//大神配置  
export const authorpage = params => {
    return axios.post(`/famousAuthor/page`, {
        ...params
    })
};

//添加作者     
export const authorinsert = params => {
    return axios.post(`/famousAuthor/insert`, {
        ...params
    })
};

//修改作者  
export const authorupdate = params => {
    return axios.post(`/famousAuthor/update`, {
        ...params
    })
};

//删除作者  
export const authordelete = params => {
    return axios.post(`/famousAuthor/delete`, {
        ...params
    })
};



//帮助查询   
export const helppage = params => {
    return axios.post(`/help/page`, {
        ...params
    })
};

//添加帮助   
export const helpinsert = params => {
    return axios.post(`/help/insert`, {
        ...params
    })
};

//修改帮助  
export const helpupdate = params => {
    return axios.post(`/help/update`, {
        ...params
    })
};

//删除帮助
export const helpdelete = params => {
    return axios.post(`/help/delete`, {
        ...params
    })
};


//底栏查询

export const bottomBarpage = params => {
    return axios.post(`/bottomBar/page`, {
        ...params
    })
};

//底栏删除  

export const bottomBardelete = params => {
    return axios.post(`/bottomBar/delete`, {
        ...params
    })
};

//添加底栏   
export const bottomBarinsert = params => {
    return axios.post(`/bottomBar/insert`, {
        ...params
    })
};

//修改底栏
export const bottomBarupdate = params => {
    return axios.post(`/bottomBar/update`, {
        ...params
    })
};



//封禁账号  
export const customerupdateCustomerStatus = params => {
    return axios.post(`/customer/updateCustomerStatus`, {
        ...params
    })
};

//修改用户属性   
export const customerupdateCustomerInfo = params => {
    return axios.post(`/customer/updateCustomerInfo`, {
        ...params
    })
};

//修改手机  
export const customerupdateCustomerBindPhone = params => {
    return axios.post(`/customer/updateCustomerBindPhone`, {
        ...params
    })
};





//书库列表   
export const categoryParentlist = params => {
    return axios.post(`/categoryParent/list`, {
        ...params
    })
};

//子类名字查ID  
export const categorylist = params => {
    return axios.post(`/category/list`, {
        ...params
    })
};


//子类ID查名字   

export const categorygetDtoBySubcategoryId = params => {
    return axios.post(`/category/getDtoBySubcategoryId`, {
        ...params
    })
};

//修改书库  /categoryParent/update
export const categoryParentupdate = params => {
    return axios.post(`/categoryParent/update`, {
        ...params
    })
};

//添加书库   
export const categoryParentinsert = params => {
    return axios.post(`/categoryParent/insert`, {
        ...params
    })
};





//配置   
export const readerGuidinglist = params => {
    return axios.post(`/readerGuiding/list`, {
        ...params
    })
};

//导读修改   
export const readerGuidingupdate = params => {
    return axios.post(`/readerGuiding/update`, {
        ...params
    })
};

//导读添加   
export const readerGuidinginsert = params => {
    return axios.post(`/readerGuiding/insert`, {
        ...params
    })
};

//  导读删除   
export const readerGuidingdelete = params => {
    return axios.post(`/readerGuiding/delete`, {
        ...params
    })
};

//操作记录  

export const customerMrRecordpage = params => {
    return axios.post(`/customerMrRecord/page`, {
        ...params
    })
};

//游客统计   
export const visitordata = params => {
    return axios.post(`/visitor/data`, {
        ...params
    })
};

//活动列表  
export const popactivilist = params => {
    return axios.post(`/popupWindowManager/activityConfiglist`, {
        ...params
    })
};


//书籍专题   
export const bookSubjectlist = params => {
    return axios.post(`/bookSubject/list`, {
        ...params
    })
};

//书籍专题删除    
export const bookSubjectdeleteBookSubject = params => {
    return axios.post(`/bookSubject/deleteBookSubject`, {
        ...params
    })
};



//新增或添加  
export const bookSubjectsaveOrUpdate = params => {
    return axios.post(`/bookSubject/saveOrUpdate`, {
        ...params
    })
};


//男女生专区查询   
export const thememodulelistByThemeId = params => {
    return axios.post(`/theme_module/listByThemeId`, {
        ...params
    })
};

//男生专区查询  
export const thememodulegetById = params => {
    return axios.post(`/theme_module/getById`, {
        ...params
    })
};

//专区修改  
export const thememoduleupdate = params => {
    return axios.post(`/theme_module/update`, {
        ...params
    })
};

//添加专区  
export const thememoduleinsert = params => {
    return axios.post(`/theme_module/insert`, {
        ...params
    })
};


// 书籍评论列表   
export const bookCommendlist = params => {
    return axios.post(`/bookCommend/list`, {
        ...params
    })
};

//评论审核  
export const bauditBookCommend = params => {
    return axios.post(`/bookCommend/auditBookCommend`, {
        ...params
    })
};

//修改评论  
export const bookCommendupdateBookCommend = params => {
    return axios.post(`/bookCommend/updateBookCommend`, {
        ...params
    })
};


//背景图查询  
export const backgroundImagelist = params => {
    return axios.post(`/backgroundImage/list`, {
        ...params
    })
};

//修改背景图片  
export const backPictureUrl = params => {
    return axios.post(`/backgroundImage/updatePictureUrl`, {
        ...params
    })
};

// 删除背景图   
export const bacImagedele = params => {
    return axios.post(`/backgroundImage/deletePictureUrl`, {
        ...params
    })
};

//启用停用  
export const backupdateStatus = params => {
    return axios.post(`/backgroundImage/updateStatus`, {
        ...params
    })
};


//大神，推荐卡片列表  
export const cardlist = params => {
    return axios.post(`/card/list`, {
        ...params
    })
};

//修改卡片   
export const cardUpdate = params => {
    return axios.post(`/card/saveOrUpdate`, {
        ...params
    })
};

//启用停用卡片   
export const cardupdateStatus = params => {
    return axios.post(`/card/updateStatus`, {
        ...params
    })
};

//个人中心分页查询   
export const personalCenterlist = params => {
    return axios.post(`/personalCenter/list`, {
        ...params
    })
};

//个人中心新增  
export const personalCenterinsert = params => {
    return axios.post(`/personalCenter/insert`, {
        ...params
    })
};

//个人中心修改 
export const personalCenterupdate = params => {
    return axios.post(`/personalCenter/update`, {
        ...params
    })
};

//个人中心状态修改   

export const personalCenterupdateStatus = params => {
    return axios.post(`/personalCenter/updateStatus`, {
        ...params
    })
};

//机器人分页查询  
export const robotpage = params => {
    return axios.post(`/robot/page`, {
        ...params
    })
};

//修改机器人状态   
export const robotupdateStatus = params => {
    return axios.post(`/robot/updateStatus`, {
        ...params
    })
};


//添加机器人   
export const robotinsert = params => {
    return axios.post(`/robot/insert`, {
        ...params
    })
};

//修改机器人   
export const robotupdate = params => {
    return axios.post(`/robot/update`, {
        ...params
    })
};


//评论库查询   
export const commentStackpage = params => {
    return axios.post(`/commentStack/page`, {
        ...params
    })
};


//添加评论  
export const commentStackinsert = params => {
    return axios.post(`/commentStack/insert`, {
        ...params
    })
};

//修改评论   


//评论状态修改  


export const commentStackupdateStatus = params => {
    return axios.post(`/commentStack/updateStatus`, {
        ...params
    })
};

//活动列表  
export const activitylist = params => {
    return axios.post(`/activity/list`, {
        ...params
    })
};

//修改活动   

export const activitysaveOrUpdate = params => {
    return axios.post(`/activity/saveOrUpdate`, {
        ...params
    })
};

//奖品表   
export const activitylistAwardInfo = params => {
    return axios.post(`/activity/listAwardInfo`, {
        ...params
    })
};

//奖品规则  
export const activitylistRule = params => {
    return axios.post(`/activity/listRule`, {
        ...params
    })
};

//奖品位置  
export const activitylistPosition = params => {
    return axios.post(`/activity/listPosition`, {
        ...params
    })
};

//启用停用活动   
export const activityupdateStatus = params => {
    return axios.post(`/activity/updateStatus`, {
        ...params
    })
};

//奖品列表 
export const awardlist = params => {
    return axios.post(`/award/list`, {
        ...params
    })
};

//奖品修改  
export const awardsaveOrUpdate = params => {
    return axios.post(`/award/saveOrUpdate`, {
        ...params
    })
};

//实物奖品添加   
export const awardsaveOrUpdateAwardItem = params => {
    return axios.post(`/award/saveOrUpdateAwardItem`, {
        ...params
    })
};

//奖品启用 停用   
export const awardupdateStatus = params => {
    return axios.post(`/award/updateStatus`, {
        ...params
    })
};

// 查询助手  
export const communicationAcountpage = params => {
    return axios.post(`/communicationAcount/page`, {
        ...params
    })
};

// 男女模块停用
export const themeareaupdateStatus = params => {
    return axios.post(`/theme_area/updateStatus`, {
        ...params
    })
};

//男女停用
export const thememoduleupdateStatus = params => {
    return axios.post(`/theme_module/updateStatus`, {
        ...params
    })
};

//推送  
export const communicationMessageinsert = params => {
    return axios.post(`/communicationMessage/insert`, {
        ...params
    })
};

//  推送列表  
export const communicationMessagepage = params => {
    return axios.post(`/communicationMessage/page`, {
        ...params
    })
};

//撤销
export const communicationMessageupdateSendStatus = params => {
    return axios.post(`/communicationMessage/updateSendStatus`, {
        ...params
    })
};