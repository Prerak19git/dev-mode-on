# Inline Functions and Keywords in Kotlin

## 1. Inline Functions

### `inline fun repeatYourself(times: Int, task: () -> Unit)`

- In this case, the lambda `task` is inlined (by default, as the function is marked `inline`).
- The `task` lambda can **allow local returns** when defined at the call site.
- **No new object** is created for the lambda; it's essentially copied/pasted where it is used.
- The `task` lambda **cannot be passed** or **stored** from inside the `repeatYourself` function.

---

## 2. `noinline` Keyword

### `inline fun repeatYourself(times: Int, noinline task: () -> Unit)`

- Here, the specific lambda `task` will be treated as **non-inline**.
- It will **allow local returns** at the caller site, where it returns from the closest scoped function.
- **An object will be created** for the lambda `task` at runtime.
- Additionally, it can be **passed to other functions** from inside the `repeatYourself` function.

---

## 3. `crossinline` Keyword

### `inline fun repeatYourself(times: Int, crossinline task: () -> Unit)`

- In this case, the lambda `task` is still treated as inline.
- However, **local returns are not allowed** at the caller site.
- **No object** will be created for the `task` lambda at runtime.
- The `task` lambda **cannot be passed or stored** from inside the `repeatYourself` function.

---

## Summary of Differences

| Keyword       | Lambda Behavior | Object Creation | Local Return | Passing Lambda |  
| ------------- | --------------- | --------------- | ------------ | -------------- |  
| `inline`      | Inlined (replaces code in place) | No             | Allowed      | Not Allowed     |  
| `noinline`    | Non-inlined (creates an object) | Yes            | Allowed      | Allowed         |  
| `crossinline` | Inlined, but disallows local return | No            | Not Allowed  | Not Allowed     |
