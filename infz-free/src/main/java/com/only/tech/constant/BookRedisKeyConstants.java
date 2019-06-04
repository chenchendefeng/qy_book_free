package com.only.tech.constant;

/**
 * @author ZHI ZUN BAO
 * @since 2018/11/19
 */
public interface BookRedisKeyConstants {

    /**
     * 热门推荐
     */
    String HOT_BOOK_RECOMMEND = "book:hot_book_recommend:";

    /**
     * 热门分类
     */
    String HOT_CATEGORY = "book:hot_category";

    /**
     * 一级分类的书籍数
     */
    String REDIS_BOOK_CHOICE_COUNT = "book:redis_book_choice_count:";


    /**
     * 用户没有加入书架的免费书籍
     */
    String REDIS_FREE_BOOK = "book:redis_free_book:";


    /**
     * 用户可领的免费书籍
     */
    String USER_FREE_BOOK = "book:user_free_book:";

    /**
     * 章节内容URL
     */
    String CHAPTER_OSS_URL = "book:chapter_oss_url:";

    /**
     * 所有章节
     */
    String CHAPTER_LIST = "book:chapter_list:";

    /**
     * 章节分页
     */
    String CHAPTER_PAGE = "book:chapter_page:";

    /**
     * 章节权限
     */
    String CHAPTER_CHECKAUTH = "book:chapter_checkauth:";

    /**
     * 书架数量
     */
    String BOOK_SHELF_COUNT = "book:book_shelf_count:";

    /**
     * redis书籍触发队列key
     */
    String REDIS_TOUCHOFFBOOK = "book:touchoffbook:";

    /**
     * 新书分页
     */
    String NEW_BOOK_PAGE = "book:newBookPage:";

    /**
     * 章节包分页
     */
    String CHAPTER_PACK_PAGE = "book:chapterPackPage:";

    /**
     * 章节DTO list正序
     */
    String CHAPTERDTO_LIST_ASC = "book:chapterDtoList_asc:";

    /**
     * 章节DTO list倒叙
     */
//    String CHAPTERDTO_LIST_DESC = "book:chapterDtoList_desc:";

    /**
     * 书籍信息
     */
    String BOOKINFO = "book_free:bookInfo:";

    /**
     * 阅文书籍信息
     */
    String BOOKINFO_YW = "book:bookInfoYw:";

    /**
     * 书籍标签
     */
    String BOOKINFO_LABEL_RELATION = "book:BookinfoLabelRelation:";

    /**
     * 购买书籍
     */
    String BUYBOOK = "book:buyBook:";


    /**
     * 购买章节
     */
    String BUYCHAPTER = "book:buyChapter:";

    /**
     * 章节
     */
    String FAST_CHAPTERDTO = "book:FastChapterDto:";

    /**
     * 购买章节数量
     */
    String BUY_CHAPTER_COUNT = "book:buyChapterCount:";


    /**
     * 阅读进度
     */
    String READ_PROGRESS = "book:read_progress:";

    /**
     * 子类别
     */
    String SUBCATEGORY = "book:subcategory:";

    /**
     * 用户看书的类别
     */
    String READ_BOOK_CATEGORY = "book:UReadBookCategory:";

    /**
     * 章节
     */
    String CHAPTER = "book:chapter:";

    /**
     *  书籍关系
     */
    String CATEGORY_RELATION = "book:categoryRelation:";

    /**
     * 书籍集合  根据关键字查询
     */
    String BOOKINFO_LIST_BY_KEYWORD = "book:keyWordBookInfoList:";

    /**
     * 书籍热度
     */
    String BOOK_HOT = "book_free:bookHot:";

    /**
     * 书籍销售数量
     */
    String BOOK_SALE_COUNT = "book:saleCount:";

    /**
     * 购买书籍数量
     */
    String BUY_BOOK_COUNT = "book:buyBookCount:";

    /**
     * 章节购买数量
     */
    String CHAPTER_SALE_COUNT_BY_CBID = "book:chapterSaleCount:";

    /**
     * 用户操作书籍更新的时间字符串
     */
    String USER_BOOK_UPDATE_TIME_STR = "book:userBookUpdateTimeStr:";

    /**
     * 用户操作书籍更新的时间字符串
     */
    String USER_BOOK_UPDATE_TIME = "book:userBookUpdateTime:";

    /**
     * 用户操作书籍更新时间 分页
     */
    String USER_BOOK_UPDATE_TIME_PAGE = "book:userBookUpdateTimePage:";

    /**
     * 书架列表分页
     */
    String BOOK_SHELF = "book_free:bookShelf:";

    /**
     * 书籍阅读进度
     */
    String USER_READ_BOOK_PROCESS = "book:userReadBookProcess:";

    /**
     * 章节数量
     */
    String CHAPTER_COUNT = "book:chapterCount:";


    /**
     * 标签
     */
    String LABEL = "book:label:";

    /**
     * 书籍标签关系集合
     */
    String BOOKINFO_LABEL_RELATION_LIST = "book:bookInfoLabelRelationList:";

    /**
     * 书籍价格配置
     */
    String BOOK_PRICE_CONFIG = "book:priceConfig:";

    /**
     * 猜你喜欢的书籍
     */
    String USER_LIKE_BOOKS = "book:likeBooks:";

    /**
     * 主题专区分页书籍
     */
    String THEME_PAGE = "book:themePage:";

    /**
     * 主题专区，模块书籍分页查询
     */
    String THEME_MODULE_PAGE = "book:themeModulePage:";

    /**
     * 性别小说
     */
    String BOOK_INFO_MARK = "book_free:bookInfoMark:";

    /**
     * 热门推荐
     */
    String HOT_RECOMMEND = "book:hotRecommend:";

    /**
     * 精选好书
     */
    String CHOICE_HOT_BOOK = "book:choiceHotBook:";
}
