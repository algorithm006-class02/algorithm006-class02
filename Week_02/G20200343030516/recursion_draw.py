import turtle

def  tree(branch_len):
    if branch_len > 5: # 树干太短不画
        t.forward(branch_len) # 树干
        t.right(20) # right rotate 20 degree
        tree(branch_len -15) # 绘画右边枝干
        t.left(40) # 相当于 left rotate 20 degree 
        tree(branch_len-15)
        t.right(20) # 回正
        t.back(branch_len)

t = turtle.Turtle()
t.left(90)
t.penup()
t.backward(100)
t.pendown()
t.pencolor('green')
t.pensize(2)
tree(75)
t.hideturtle()
turtle.done()


# def  tree(branch_len):
#     if branch_len > 5: # 树干太短不画
#         t.forward(branch_len) # 树干
#         t.right(20) # right rotate 20 degree
#         tree(branch_len -15) # 绘画右边枝干
#         t.left(40) # 相当于 left rotate 20 degree 
#         tree(branch_len-15)
#         t.right(20) # 回正
#         t.back(branch_len)