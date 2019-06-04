//storage操作
export const setStore = (name, content) => {
    if (!name) return;
    if (typeof content !== 'string') {
        content = JSON.stringify(content);
    }
    window.sessionStorage.setItem(name, content);
}

export const getStore = name => {
    if (!name) return;
    return window.sessionStorage.getItem(name);
}

export const removeStore = name => {
    if (!name) return;
    window.sessionStorage.removeItem(name);
}

export const setlocal = (name, content) => {
    if (!name) return;
    if (typeof content !== 'string') {
        content = JSON.stringify(content);
    }
    window.localStorage.setItem(name, content);
}

export const getlocal = name => {
    if (!name) return;
    return window.localStorage.getItem(name);
}

export const removelocal = name => {
    if (!name) return;
    window.localStorage.removeItem(name);
}

export const Utils = {
    uuid() {
        return 'xxxx-4xxx-yxxx'.replace(/[xy]/g, n => {
            let r = Math.random() * 16 | 0,
                v = n == 'x' ? r : (r & 0x3 | 0x8)
            return v.toString(16)
        }).toUpperCase()
    },
    rids() {
         return Math.floor(Math.random()*Math.pow(10,6))
    }
}

//日期处理
export const Dates = {
    // 本月最后一天
    getFormatDate(a) {
        var date = new Date(a);
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentDate = date.getFullYear() + "-" + month + "-" + strDate
        return currentDate;
    },

    //本月第一天
    getCurrentMonthFirst(){
        var date = new Date();
        date.setDate(1);
        var month = parseInt(date.getMonth()+1);
        var day = date.getDate();
        if (month < 10) {
            month = '0' + month
        }
        if (day < 10) {
            day = '0' + day
        }
        return date.getFullYear() + '-' + month + '-' + day;
    },

    /**
     * 日期格式化, 第一个参数是日期,第二个参数是格式
     * @param date
     * @param format 格式,默认是 yyyy-MM-dd HH:mm:ss
     * @returns
     */
    
    formatDate(date, format = 'yyyy-MM-dd HH:mm:ss') {
        if (!date) {
            return
        }
        if (typeof date == 'string' && date.indexOf('-') >= 0) {
            if (format == 'yyyy-MM') {
                return date.substring(0, 7)
            } else {
                return date
            }
        }

        switch (typeof date) {
            case "string":
                date = new Date(date.replace(/-/, "/"))
                break
            case "number":
                date = new Date(date)
                break
        }

        if (!date instanceof Date) {
            return
        }

        const dict = {
            "yyyy": date.getFullYear(),
            "M": date.getMonth() + 1,
            "d": date.getDate(),
            "H": date.getHours(),
            "m": date.getMinutes(),
            "s": date.getSeconds(),
            "MM": ("" + (date.getMonth() + 101)).substr(1),
            "dd": ("" + (date.getDate() + 100)).substr(1),
            "HH": ("" + (date.getHours() + 100)).substr(1),
            "mm": ("" + (date.getMinutes() + 100)).substr(1),
            "ss": ("" + (date.getSeconds() + 100)).substr(1)
        }
        return format.replace(/(yyyy|MM?|dd?|HH?|ss?|mm?)/g, function () {
            return dict[arguments[0]]
        })
    },

    /**
     * 检查日期,开始时间不能大于结束时间, 支持时分秒,格式为 yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @returns {Boolean} 检查通过true,否则false
     */
    checkDate(startDate, endDate) {
        startDate = getDateMills(startDate)
        endDate = getDateMills(endDate)
        return (endDate >= startDate)
    },

    /**
     *   获取日期的毫秒数
     *   @param date 日期, 格式支持yyyy-MM-dd 或者 yyyy-MM-dd HH:mm:ss
     */
    getDateMills(date) {
        const dateAndTimeArray = date.split(" ") // 2017-01-02
        let newDate

        if (dateAndTimeArray[1]) {
            const dateArray = dateAndTimeArray[0].split("-")
            const timeArray = dateAndTimeArray[1].split(":")
            newDate = new Date(dateArray[0], dateArray[1], dateArray[2], timeArray[0], timeArray[1], timeArray[2])
        } else {
            const dateArray = dateAndTimeArray[0].split("-")
            newDate = new Date(dateArray[0], dateArray[1], dateArray[2])
        }

        const dateMills = newDate.getTime()
        return dateMills
    },
}
