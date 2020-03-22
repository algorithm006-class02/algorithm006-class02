```python
# -----------------
# User Instructions
# 
# Write a function, mc_problem2, that solves the missionary and cannibal
# problem by making a call to shortest_path_search. Add any code below
# and change the arguments in the return statement's call to the 
# shortest_path_search function.

def mc_problem2(start=(3, 3, 1, 0, 0, 0), goal=None):
    if goal is None:
        def goal_fn(state): return state[:3] == (0, 0, 0)
    else:
        def goal_fn(state): return state == goal
    return shortest_path_search(start, csuccessors, goal_fn)
   

def shortest_path_search(start, successors, is_goal):
    """Find the shortest path from start state to a state
    such that is_goal(state) is true."""
    if is_goal(start):
        return [start]
    explored = set()
    frontier = [ [start] ] 
    while frontier:
        path = frontier.pop(0)
        s = path[-1]
        for (state, action) in successors(s).items():
            if state not in explored:
                explored.add(state)
                path2 = path + [action, state]
                if is_goal(state):
                    return path2
                else:
                    frontier.append(path2)
    return Fail
Fail = []

def csuccessors(state):
    """Find successors (including those that result in dining) to this
    state. But a state where the cannibals can dine has no successors."""
    M1, C1, B1, M2, C2, B2 = state
    ## Check for state with no successors
    if C1 > M1 > 0 or C2 > M2 > 0:
        return {}
    items = []
    if B1 > 0:
        items += [(sub(state, delta), a + '->')
                  for delta, a in deltas.items()]
    if B2 > 0:
        items += [(add(state, delta), '<-' + a)
                  for delta, a in deltas.items()]
    return dict(items)

def add(X, Y):
    "add two vectors, X and Y."
    return tuple(x+y for x,y in zip(X, Y))

def sub(X, Y):
    "subtract vector Y from X."
    return tuple(x-y for x,y in zip(X, Y))

deltas = {(2, 0, 1,    -2,  0, -1): 'MM',
          (0, 2, 1,     0, -2, -1): 'CC',
          (1, 1, 1,    -1, -1, -1): 'MC',
          (1, 0, 1,    -1,  0, -1): 'M',
          (0, 1, 1,     0, -1, -1): 'C'}

def test():
    assert mc_problem2(start=(1, 1, 1, 0, 0, 0)) == [
                             (1, 1, 1, 0, 0, 0), 'MC->',
                             (0, 0, 0, 1, 1, 1)]
    assert mc_problem2() == [(3, 3, 1, 0, 0, 0), 'CC->', 
                             (3, 1, 0, 0, 2, 1), '<-C', 
                             (3, 2, 1, 0, 1, 0), 'CC->', 
                             (3, 0, 0, 0, 3, 1), '<-C', 
                             (3, 1, 1, 0, 2, 0), 'MM->', 
                             (1, 1, 0, 2, 2, 1), '<-MC', 
                             (2, 2, 1, 1, 1, 0), 'MM->', 
                             (0, 2, 0, 3, 1, 1), '<-C', 
                             (0, 3, 1, 3, 0, 0), 'CC->', 
                             (0, 1, 0, 3, 2, 1), '<-C', 
                             (0, 2, 1, 3, 1, 0), 'CC->', 
                             (0, 0, 0, 3, 3, 1)]
    return 'tests pass'

print test() 
```