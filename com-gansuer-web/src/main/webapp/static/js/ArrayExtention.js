/**
 * Created by Frank on 3/8/16.
 */
/* 扩展js原生的array */
Array.prototype.indexOf = function (obj) {
    for (var i = 0; i < obj.length; i++) {
        if (this[i] == obj) {
            return i;
        }
    }
    return -1;
}
Array.prototype.remove = function (object) {
    var index = this.indexOf(object);
    for (var i = 0; i < this.length; i++) {
        if (this[i] == object) {
            index = i;
            break;
        }
    }
    if (index != -1) {
        this.splice(index, 1);
    }
}

Array.prototype.contains = function (obj) {
    for (i = 0; i < this.length; i++) {
        if (obj == this[i]) {
            return true;
        }
    }
    return false;
}

Array.prototype.contains1 = function (callback) {
    for (i = 0; i < this.length; i++) {
        if (callback(this[i])) {
            return true;
        }
    }
    return false;
}

Array.prototype.clone = function () {
    return this.slice(0);
};

/**
 * 合并数组
 * @param arr
 * @returns {*}
 */
Array.prototype.merge = function (arr) {
    if (arr == null || typeof(arr) == "undefined") {
        return this;
    }

    return this.concat(arr);
};
