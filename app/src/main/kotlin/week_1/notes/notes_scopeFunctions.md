package org.example.app.notes.week_1

# 📘 Kotlin Scope Functions: `let`, `run`, `with`, `apply`, `also`

---

## 🔹 `let`

- **Usage**: `x?.let { }`
- **Extension Function**: ✅ Yes
- **Reference**: `it` (can be renamed)
- **Returns**: Result of the lambda
- **Use Case**:
    - Handling nullable values
    - Limiting the scope of a variable
    - Transforming or chaining operations

```kotlin
val name: String? = "Kotlin"
name?.let {
    println("Length: ${it.length}")
}
```

---

## 🔹 `run`

- **Usage**: `x.run { }` or `run { }`
- **Extension Function**: ✅ Yes (also a standalone function)
- **Reference**: `this`
- **Returns**: Result of the lambda
- **Use Case**:
    - Performing computations or side effects
    - Returning the result of the last statement

```kotlin
val result = "Kotlin".run {
    println("Uppercase: ${this.uppercase()}")
    this.length
}
```

---

## 🔹 `with`

- **Usage**: `with(x) { }`
- **Extension Function**: ❌ No
- **Reference**: `this`
- **Returns**: Result of the lambda
- **Use Case**:
    - Operating on an object without extension
    - Grouping multiple operations on the same object

```kotlin
val result = with(StringBuilder()) {
    append("Hello, ")
    append("World!")
    toString()
}
```

---

## 🔹 `apply`

- **Usage**: `x.apply { }`
- **Extension Function**: ✅ Yes
- **Reference**: `this`
- **Returns**: The object itself
- **Use Case**:
    - Object configuration
    - Initialization patterns (especially in builders or DSLs)

```kotlin
val person = Person().apply {
    name = "Alice"
    age = 28
}
```

---

## 🔹 `also`

- **Usage**: `x.also { }`
- **Extension Function**: ✅ Yes
- **Reference**: `it` (can be renamed)
- **Returns**: The object itself
- **Use Case**:
    - Side effects (logging, debugging, validation)
    - Performing actions without modifying the object

```kotlin
val numbers = mutableListOf(1, 2, 3).also {
    println("Original list: $it")
}
```

---

## 📊 Summary Table

| Function | Extension | Reference | Returns         | Use Case                            |
|----------|------------|-----------|------------------|--------------------------------------|
| `let`    | ✅ Yes     | `it`      | Lambda result    | Null checks, result transformation   |
| `run`    | ✅ Yes     | `this`    | Lambda result    | Computations, expressions            |
| `with`   | ❌ No      | `this`    | Lambda result    | Grouped object operations            |
| `apply`  | ✅ Yes     | `this`    | Receiver object  | Configuration, initialization        |
| `also`   | ✅ Yes     | `it`      | Receiver object  | Logging, validation, side effects    |

---

🧠 **Tips**:
- Use `let` for chaining and null safety.
- Use `run` and `with` when you need the result from operations.
- Use `apply` and `also` for configuring and working with the object itself.
