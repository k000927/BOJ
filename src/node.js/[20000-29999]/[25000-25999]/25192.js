// let input = require("fs").readFileSync("input.txt").toString().split("\n");
let input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let ans = 0;
const N = input[0];
const set = new Set();
for (let i = 1; i <= N; i++) {
  const str = input[i];
  if (str === "ENTER") {
    set.clear();
    continue;
  }

  if (!set.has(str)) {
    set.add(str);
    ans++;
  }
}

console.log(ans);
