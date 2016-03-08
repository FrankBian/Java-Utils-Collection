/**
 * Created by Frank on 3/8/16.
 */
function goUrl(url) {
    location.href = url;
}

function trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

function stringIsNullOrEmpty(value) {
    if (typeof(value) == "undefined" || value == null || value == "") {
        return true;
    }
    return false;
}

function isNull(value) {
    if (typeof(value) == "undefined" || value == null) {
        return true;
    }
    return false;
}

function NumberTOWeek(num) {
    switch (num.toString()) {
        case "0":
            return "星期日";
        case "1":
            return "星期一";
        case "2":
            return "星期二";
        case "3":
            return "星期三";
        case "4":
            return "星期四";
        case "5":
            return "星期五";
        case "6":
            return "星期六";
        case "7":
            return "星期日";
        default   :
            return "";
    }
}
