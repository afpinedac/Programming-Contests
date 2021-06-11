// 2*O(n)

var twoSum = function (nums, target) {

  let dict = {}
  let numbers = []

  //O(n)
  nums.every((k, i) => {

    if (dict[target - k] !== undefined) {
      numbers = [k, target - k]
      return false
    }
    dict[k] = true

    return true
  })

  //O(n)

  let solution = []
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] == numbers[0]) {
      solution.push(i)
      break
    }
  }

  let secondIndex = nums.findIndex((n, i) => n == numbers[1] && i != solution[0])
  solution.push(secondIndex)
  return solution

}

const tests = [
  [[2, 7, 11, 15], 9], // => [0,1]
  [[3, 2, 4], 6], // => [1,2]
  [[3, 3], 6], // => [0,1]
  [[88888, 3, 88888, 88888, 1], 88889] // => [0,1]
]

tests.forEach((e, i) => {
  console.log(twoSum(...e))
})