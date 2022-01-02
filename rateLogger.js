const map = {};
const logger = (timeStamp, message) => {
  if (map[message] === undefined) {
    map[message] = timeStamp;
    return true;
  } else {
    if (timeStamp - map[message] < 10) {
      return false;
    }
    map[message] = timeStamp;
    return true;
  }
};

console.log(logger(1, "foo"));
console.log(logger(2, "bar"));
console.log(logger(3, "foo"));
console.log(logger(8, "bar"));
console.log(logger(10, "foo"));
console.log(logger(11, "foo"));
