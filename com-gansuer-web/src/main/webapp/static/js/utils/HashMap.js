/**
 * Created by Frank on 2014/11/26.
 */
/*  region 一些扩展的工具类*/
/* js实现的HashMap */
function HashMap() {
    // 定义属性
    this.keys = new Array();
    this.values = new Array();
    this.length = 0;

    var forEachIn = function (key, value, action) {
        action(key, value);
    };

    HashMap.prototype.forEach = function (action) {
        for (var i = 0; i < this.length; i++) {
            forEachIn(this.keys[i], this.values[i], action);
        }
    };

    HashMap.prototype.keySet = function () {
        return this.keys;
    };

    HashMap.prototype.put = function (key, value) {
        var i = 0;
        if (typeof(key) == "undefined") {
            return;
        }
        for (; i < this.length; i++) {
            if (this.keys[i] == key) {
                break;
            }
        }
        if (i == this.length) {
            this.keys.push(key);
            this.values.push(value);
            this.length++;
        } else {
            this.values[i] = value;
        }
    };

    HashMap.prototype.get = function (key) {
        var i = 0;
        for (; i < this.length; i++) {
            if (this.keys[i] == key) {
                break;
            }
        }
        if (i != this.length) {
            return this.values[i];
        }
        return null;
    };

    HashMap.prototype.remove = function (key) {
        for (var i = 0; i < this.length; i++) {
            if (this.keys[i] == key) {
                this.keys.remove(this.keys[i]);
                this.values.remove(this.values[i]);
                this.length--;
                break;
            }
        }
    };

    HashMap.prototype.containsKey = function (key) {
        var ret = false;
        for (var i = 0; i < this.length; i++) {
            if (this.keys[i] == key) {
                ret = true;
                break;
            }
        }
        return ret;
    };

    HashMap.prototype.toString = function () {
        var array = new Array();
        for (var i = 0; i < this.length; i++) {
            array[this.keys[i]] = this.values[i];
        }
        return JSON.stringify(array);
    };
}


/*endregion 一些扩展的工具类*/