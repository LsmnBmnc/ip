# Nana User Guide

![UI Example](ui.png)

**Welcome to Nana, your personal task management chatbot.**

Nana manages your tasks with priority efficiently by organizing them into three categories: Todos, Deadlines, and Events.

## Adding deadlines

Add a deadline by providing the task description and the due date.

Example: `deadline Assignment 1 /by 2025-02-19`

Expected output:

```
    ____________________________________________________________
     Got it. I've added this task:
       [D][ ]Assignment 1  (by:Feb 19 2025)
     Now you have 4 tasks in the list.
    ____________________________________________________________
```

## Searching for Tasks

Search for tasks by providing a keyword.

Example: `find study`

Expected output if task is found:

```
    ____________________________________________________________
     Here are the matching tasks in your list:
     1.[E][ ]study  (from: /from Monday to:Tuesday)
    ____________________________________________________________
```

## Deleting Tasks

Delete a task by providing the task index in the list.

Example: `delete 2`

Expected output if task is found:

```
    ____________________________________________________________
     Noted. I've removed this task:
       [E][ ]study  (from: /from Monday to:Tuesday)
     Now you have 3 tasks in the list.
    ____________________________________________________________
```