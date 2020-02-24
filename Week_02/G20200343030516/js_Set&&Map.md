### javaScript  Map && Set

#### Set 
The [Set](https://developer.mozilla.org/en-US/docs/web/javascript/reference/global_objects/set) object lets you store unique values of any type, whether primitive values or object references.

##### Methods

**Properties**

+  Set.prototype.constructor

Returns the function that created an instance's prototype. This is the Set function by default.
Set.prototype.size
Returns the number of values in the Set object.
Methods

+ Set.prototype.has(value)

    Returns a boolean asserting whether an element is present with the given value in the Set object or not.

**Mutator methods**

These methods modify the set.

+ Set.prototype.add(value)
    Appends value to the Set object. Returns the Set object.
+ Set.prototype.clear()
    Removes all elements from the Set object.
+ Set.prototype.delete(value)
    Removes the element associated to the value and returns the value that Set.prototype.has(value) would have previously returned. Set.prototype.has(value) will return false afterwards.
Iteration methods

+ Set.prototype.entries()

    Returns a new Iterator object that contains an array of [value, value] for each element in the Set object, in insertion order.

This is similar to the Map object, so that each entry's key is the same as its value for a Set.

+ Set.prototype.forEach(callbackFn[, thisArg])

Calls callbackFn once for each value present in the Set object, in insertion order. If a thisArg parameter is provided, it will be used as the this value for each invocation of callbackFn.

+ Set.prototype.keys()

    Returns a new Iterator object that yields the values for each element in the Set object in insertion order. (For Sets, this is the same as the values() method.)

+ Set.prototype.values()

    Returns a new Iterator object that yields the values for each element in the Set object in insertion order.

+ Set.prototype[@@iterator]()

    Returns a new Iterator object that yields the values for each element in the Set object in insertion order.

```javascript
let mySet = new Set()

mySet.add(1)           // Set [ 1 ]
mySet.add(5)           // Set [ 1, 5 ]
mySet.add(5)           // Set [ 1, 5 ]
mySet.add('some text') // Set [ 1, 5, 'some text' ]
let o = {a: 1, b: 2}
mySet.add(o)

mySet.add({a: 1, b: 2})   // o is referencing a different object, so this is okay

mySet.has(1)              // true
mySet.has(3)              // false, since 3 has not been added to the set
mySet.has(5)              // true
mySet.has(Math.sqrt(25))  // true
mySet.has('Some Text'.toLowerCase()) // true
mySet.has(o)       // true

mySet.size         // 5

mySet.delete(5)    // removes 5 from the set
mySet.has(5)       // false, 5 has been removed

mySet.size         // 4, since we just removed one value

console.log(mySet)
// logs Set(4) [ 1, "some text", {…}, {…} ] in Firefox
// logs Set(4) { 1, "some text", {…}, {…} } in Chrome
```


**Iterating Sets**

```javascript
// iterate over items in set
// logs the items in the order: 1, "some text", {"a": 1, "b": 2}, {"a": 1, "b": 2} 
for (let item of mySet) console.log(item)

// logs the items in the order: 1, "some text", {"a": 1, "b": 2}, {"a": 1, "b": 2} 
for (let item of mySet.keys()) console.log(item)
 
// logs the items in the order: 1, "some text", {"a": 1, "b": 2}, {"a": 1, "b": 2} 
for (let item of mySet.values()) console.log(item)

// logs the items in the order: 1, "some text", {"a": 1, "b": 2}, {"a": 1, "b": 2} 
// (key and value are the same here)
for (let [key, value] of mySet.entries()) console.log(key)

// convert Set object to an Array object, with Array.from
let myArr = Array.from(mySet) // [1, "some text", {"a": 1, "b": 2}, {"a": 1, "b": 2}]

// the following will also work if run in an HTML document
mySet.add(document.body)
mySet.has(document.querySelector('body')) // true

// converting between Set and Array
mySet2 = new Set([1, 2, 3, 4])
mySet2.size                    // 4
[...mySet2]                    // [1, 2, 3, 4]

// intersect can be simulated via 
let intersection = new Set([...set1].filter(x => set2.has(x)))

// difference can be simulated via
let difference = new Set([...set1].filter(x => !set2.has(x)))

// Iterate set entries with forEach()
mySet.forEach(function(value) {
  console.log(value)
})

// 1
// 2
// 3
// 4
```

**Implementing basic set operations**

```javascript
function isSuperset(set, subset) {
    for (let elem of subset) {
        if (!set.has(elem)) {
            return false
        }
    }
    return true
}

function union(setA, setB) {
    let _union = new Set(setA)
    for (let elem of setB) {
        _union.add(elem)
    }
    return _union
}

function intersection(setA, setB) {
    let _intersection = new Set()
    for (let elem of setB) {
        if (setA.has(elem)) {
            _intersection.add(elem)
        }
    }
    return _intersection
}

function symmetricDifference(setA, setB) {
    let _difference = new Set(setA)
    for (let elem of setB) {
        if (_difference.has(elem)) {
            _difference.delete(elem)
        } else {
            _difference.add(elem)
        }
    }
    return _difference
}

function difference(setA, setB) {
    let _difference = new Set(setA)
    for (let elem of setB) {
        _difference.delete(elem)
    }
    return _difference
}

// Examples
let setA = new Set([1, 2, 3, 4])
let setB = new Set([2, 3])
let setC = new Set([3, 4, 5, 6])

isSuperset(setA, setB)          // => true
union(setA, setC)               // => Set [1, 2, 3, 4, 5, 6]
intersection(setA, setC)        // => Set [3, 4]
symmetricDifference(setA, setC) // => Set [1, 2, 5, 6]
difference(setA, setC)          // => Set [1, 2]
```

**Relation with Array objects**
```javascript
let myArray = ['value1', 'value2', 'value3']

// Use the regular Set constructor to transform an Array into a Set
let mySet = new Set(myArray)

mySet.has('value1')     // returns true

// Use the spread operator to transform a set into an Array.
console.log([...mySet]) // Will show you exactly the same Array as myArray
```

** Relation with String** 
```javascript
let text = 'inhao'
let mySet = new Set(text)//Set { 'I', 'n', 'd', 'i', 'a' }
mySet.size // 5
```


### Map
The [**Map**](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map) object holds key-value pairs and remembers the original insertion order of the keys. Any value (both objects and primitive values) may be used as either a key or a value.



A Map object iterates its elements in insertion order — a for...of loop returns an array of [key, value] for each iteration.

#### **key equality **

based on  [sameValueZero](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Equality_comparisons_and_sameness#Same-value-zero_equality) algorithm
`NaN !== NaN` But same key in Map

#### Objects vs. Maps

1. Map 的 Key 值为显式的添加进去，`Object` has defalut keys 
2. Map 的key type 可以包括任意类型，`Object` 只有String,Symbol()
3. Map's key has order,FIFO ;`Object` no order
4. Map can get size by map.size; but object's item should determined manually.
5. A Map is an iterable, so it can be directly iterated. `Object` need require it's keys in prev.
6. Map Performs better in scenarios involving frequent additions and removals of key-value pairs.

**Properties** 
.length
get Map[]

**Example**
```javascript
let myMap = new Map()

let keyString = 'a string'
let keyObj    = {}
let keyFunc   = function() {}

// setting the values
myMap.set(keyString, "value associated with 'a string'")
myMap.set(keyObj, 'value associated with keyObj')
myMap.set(keyFunc, 'value associated with keyFunc')

myMap.size              // 3

// getting the values
myMap.get(keyString)    // "value associated with 'a string'"
myMap.get(keyObj)       // "value associated with keyObj"
myMap.get(keyFunc)      // "value associated with keyFunc"

myMap.get('a string')    // "value associated with 'a string'"
                         // because keyString === 'a string'
myMap.get({})            // undefined, because keyObj !== {}
myMap.get(function() {}) // undefined, because keyFunc !== function () {}



// for ... of iter methods
let myMap = new Map()
myMap.set(0, 'zero')
myMap.set(1, 'one')

for (let [key, value] of myMap) {
  console.log(key + ' = ' + value)
}
// 0 = zero
// 1 = one

for (let key of myMap.keys()) {
  console.log(key)
}
// 0
// 1

for (let value of myMap.values()) {
  console.log(value)
}
// zero
// one

for (let [key, value] of myMap.entries()) {
  console.log(key + ' = ' + value)
}
// 0 = zero
// 1 = one



// forEach
myMap.forEach(function(value, key) {
  console.log(key + ' = ' + value)
})
// 0 = zero
// 1 = one

// relation with Array
let kvArray = [['key1', 'value1'], ['key2', 'value2']]

// Use the regular Map constructor to transform a 2D key-value Array into a map
let myMap = new Map(kvArray)

myMap.get('key1') // returns "value1"

// Use Array.from() to transform a map into a 2D key-value Array
console.log(Array.from(myMap)) // Will show you exactly the same Array as kvArray

// A succinct way to do the same, using the spread syntax
console.log([...myMap])

// Or use the keys() or values() iterators, and convert them to an array
console.log(Array.from(myMap.keys())) // ["key1", "key2"]


```

**Cloning and merging Maps**
```javascript
let original = new Map([
  [1, 'one']
])

let clone = new Map(original)

console.log(clone.get(1))       // one
console.log(original === clone) // false (useful for shallow comparison)
```







