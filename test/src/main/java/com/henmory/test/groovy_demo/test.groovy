
//groovy 高级特性
//1. 变量类型可省
def version = 1

//2.断言可以随处使用
assert version == 2

//3. 括号可省
println version


//4.字符串有三种形式

def s1 = 'henmory'

def s2 = "my gradle verison is ${version}"

def s3 = '''我可以
 换
 行'''

println s1
println s2
println s3