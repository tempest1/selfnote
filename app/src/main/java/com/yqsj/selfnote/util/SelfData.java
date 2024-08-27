package com.yqsj.selfnote.util;

import com.yqsj.selfnote.bean.Content;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2024/8/26.
 */

public class SelfData {

    public static List<Content> contents = new ArrayList<>();
    static Content content1 = new Content("字符串方法 strs.find('n') 和 strs.rfinds('n')分别是什么意思?","strs.finds('n')是从左往右第一个n的下标对应的索引（从0开始）\n" +
            "strs.rfinds('n')是从右往左第一个n的下标对应的索引\n" +
            "strs = \"I like python and java\"\n" +
            "one = strs.find('n')\n" +
            "print(one)\n" +
            "two = strs.rfind('n')\n" +
            "print(two)\n" +
            "\n" +
            "one = 12\n" +
            "two = 15",10);


    static Content content2 = new Content("字符串方法strs.strip('ab')是什么意思","去掉两边的ab字符\n" +
            "strs = 'abbacabb'\n" +
            "print(strs.strip('ab'))\n" +
            "\n" +
            "#结果为c",10);




    static Content content3 = new Content("字符串strs.count('a')意思是","字符串含小写a的个数\n" +
            "names = [\"Andrea\",\"Aaslay\",\"Steven\",\"Joa\"]\n" +
            "lists = []\n" +
            "for name in names:\n" +
            "    if name.count('a') >=2:\n" +
            "        lists.append(name)\n" +
            "print(lists)\n" +
            "\n" +
            "#结果为['Aaslay']",10);

    static Content content4 = new Content("执行程序输出结果是什么\n" +
            "def outer():\n" +
            "    def inner():\n" +
            "        print(\"inner\",end = \" \")\n" +
            "    print(\"outer\",end = \" \")\n" +
            "    return inner\n" +
            "outer()","函数的嵌套 先执行的是outer里面的内容 返回的是inner并没有执行inner函数\n" +
            "#outer",10);
    static Content content5 = new Content("以下程序输出为\n" +
            "def test(a,b,*arg):\n" +
            "    print(a)\n" +
            "    print(b)\n" +
            "    print(arg)\n" +
            "test(11,22,33,44,55,66,77,88,99)","a = 11 b = 22 后面的所有参数会形成一个元组(33, 44, 55, 66, 77, 88, 99)",10);
    static Content content6 = new Content("程序运行结果为\n" +
            "tmp = dict.fromkeys(['a','b'],4)\n" +
            "print(tmp)","字典自带的formkeys方法会生成字典{'a':4,'b':4}",10);
    static Content content7 = new Content("程序运行结果为\n" +
            "lists = [1,2,3,4]\n" +
            "tmp = 0\n" +
            "for i,j in enumerate(lists):\n" +
            "    tmp += i*j\n" +
            "print(tmp)\n","enumerate枚举下标和元素值  0*1 + 1* 2 + 2 * 3 + 3*4 = 20",10);
    static Content content8 = new Content("运行结果为\n" +
            "lists = [1,1,2,3,4,5,6]\n" +
            "lists.remove(1)\n" +
            "lists.extend([7,8,9])\n" +
            "print(lists)","remove是删除列表中的元素值删除第一个，extend([7,8,9])将7,8,9加到列表中区\n" +
            "# 答案是[1,2,3,4,5,6,7,8,9]",10);
    static Content content9 = new Content("下列程序的打印结果为\n" +
            "import re\n" +
            "str1 = \"Python's features\"\n" +
            "str2 = re.match(r'(.*)on(.*?) .*',str1,re.I)\n" +
            "print(str2.group(1))","正则表达式 str2.group(1) 捕获第一个分组on前面的内容  答案是Pyth",10);
    static Content content10 = new Content("运行结果是\n" +
            "for i in range(10,1,-2):\n" +
            "    print(i)","10到1 每一个-2不包括1 [10,8,6,4,2]",10);
    static Content content11 = new Content("python的作用域是怎么划分的","作用域是变量可以使用的区域\n" +
            "#Builtins 内建作用域 max len\n" +
            "#Global 全局作用域\n" +
            "#Enclosing 函数作用域\n" +
            "#locals 局部作用域\n" +
            "\n" +
            "c = 1 #全局作用域\n" +
            "def fn2():\n" +
            "    d = 2 #函数作用域\n" +
            "    def fn3():\n" +
            "        e = 3 # 局部作用域\n" +
            "print(max)#内建作用域\n" +
            "#在 if elif while for try except 不会引入新的作用域\n" +
            "#在函数，类，模块引入新的作用域",10);
    static Content content12 = new Content("什么是解释性语言，什么是编译性语言","#编译性语言 -> 编译器 -> 最终可执行文件->操作系统 比如说java,c++\n" +
            "#解释性语言 -> 解释器 -> 操作系统 python",10);
    static Content content13 = new Content("说说get请求和post请求不同","# 1.Get表示从指定的服务器获取数据，post 表示提交数据给指定的服务器处理\n" +
            "# 2.Get查询的字符串参数显示在地址栏的URL中，请求参数是可见的。Post查询是不可见的，请求参数是不可见的\n" +
            "# 3.Get请求可以被缓存，Post请求不能被缓存\n" +
            "# 4.Get请求有长度限制(2kb)，Post请求没有长度限制\n" +
            "# 5.Get查询的字符串参数显示在地址栏的URL中不安全，不要用get请求提交敏感数据，Post请求不会显示到地址栏，参数是不可见的，post请求比get请求安全。如果传送敏感的数据请加密。",10);
    static Content content14 = new Content("python中的正则表达式怎么提取数据","# 分组捕获\n" +
            "# 1.表达式中要把提取的内容使用分组括起来\n" +
            "# 2.然后执行match或者search匹配，匹配后使用group（num）和groups方法提取内容。或者直接用findall\n" +
            "\n" +
            "#分组() 捕获group groups findall\n" +
            "s = '0755-56789999'\n" +
            "pattern = \"(\\d{4})-(\\d{8})\"\n" +
            "r = re.match(pattern,s)\n" +
            "print(r)\n" +
            "print(r.group(1))#0755\n" +
            "print(r.group(2))#56789999\n" +
            "print(r.groups())#('0755', '56789999')\n" +
            "\n" +
            "pattern = \"(\\d{4})-(\\d{8})\"\n" +
            "#一定可以获得元组\n" +
            "print(re.findall(pattern,s))",10);
    static Content content15 = new Content("Python中args与kwargs的用法和区别","# 1.*args中是args是元组，可以通过args元组获得所有位置参数\n" +
            "# 2.**kwargs中的kwargs是字典,可以通过kwargs获取所有关键字的参数\n" +
            "# 3.在函数的形参中，如果同时有*args和**kwargs,*args必须在**kwargs前面\n" +
            "\n" +
            "#args和kwargs不是关键词只是建议使用\n" +
            "\n" +
            "def demo(*args):\n" +
            "    print(args)\n" +
            "    print(type(args))\n" +
            "demo(1,3,4,5)\n" +
            "\n" +
            "def demo2(**kwargs):\n" +
            "    print(kwargs)\n" +
            "    print(type(kwargs))\n" +
            "demo2(a=1,b=2,c=3)\n" +
            "\n" +
            "def demo3(*args,**kwargs):\n" +
            "    print(args)\n" +
            "    print(kwargs)\n" +
            "# def demo4(a,b,*args,**kwargs):\n" +
            "#     print(args)\n" +
            "#     print(kwargs)\n" +
            "demo3(1,2)\n" +
            "demo3(a=3,b=1)\n" +
            "demo3(1,3,4,a=3,c=4)\n" +
            "# demo4(a=1,b=3,1,3,4,c=3,d=4)\n" +
            "\n" +
            "#通用装饰器\n" +
            "def outer(fn):\n" +
            "    def inner(*args,**kwargs):\n" +
            "        fn(*args,**kwargs)\n" +
            "    return inner\n" +
            "def demo4(*args):\n" +
            "    print(args)\n" +
            "\n" +
            "a = [1,2,3,4]\n" +
            "demo4(a) #([1,2,3,4])\n" +
            "demo4(*a) #将参数打开(1,2,3,4)\n" +
            "\n" +
            "b = {\"a\":1,\"b\":4}\n" +
            "demo2(**b) #将参数打开{\"a\":1,\"b\":4}\n",10);
    static Content content16 = new Content("Python中的list,tuple,set,dict的区别","list和tuple属于序列，可以用下标访问，可以进行切片操作，可以排序\n" +
            "# 1.list用[]定义，tuple用()定义\n" +
            "# 2.list是可变容器，可以修改里面的元素有深复制和浅复制，tuple是不可变容器，不能修改元素，没有深复制和浅复制\n" +
            "# 3.list一般不做函数的默认值，tuple可以做函数的默认值\n" +
            "#\n" +
            "# set和dict不属于序列，无序，不能通过下标访问，但是也有区别\n" +
            "# 1.dict可以通过key访问，set不行\n" +
            "# 2.dict键不可以重复，值可以重复，set不允许有重复的元素\n" +
            "# 3.dict可以通过键修改值，set不能修改元素",10);
    static Content content17 = new Content("python中type与isinstance方法的区别","Python中我们使用type和isinstance来测试和判断数据类型\n" +
            "# 其中type中用于获取对象的类型，其中返回值是对象的类型\n" +
            "# isinstance用于测试对象是否是某种类型，返回True或者Flase\n" +
            "# 1.目的不同,type主要返回对象的类型，isinstance用于判断对象是否是指定类型\n" +
            "# 2.返回值不同 type返回类型，isinstance返回True或者False\n" +
            "# 3.type不能判断子类对象是否是父类，isinstance可以\n",10);
    static Content content18 = new Content("Python中的while-else和for-else的用法","#在循环外使用else可以在程序没有break出去的时候运行else里面的内容\n" +
            "# n = int(input(\"输入一个数\"))\n" +
            "# for i in range(2,n):\n" +
            "#     if n % i == 0:\n" +
            "#         print('%d不是素数'%n)\n" +
            "#         break\n" +
            "# else:\n" +
            "#     print('%d是不是素数'%n)\n",10);
    static Content content19 = new Content("请说说您对Python中装饰器的理解，如何实现一个通用的装饰器","1.装饰器的实现用闭包\n" +
            "# 2.装饰器是一个python函数，它可以让其他函数不做任何代码的变动上增加额外的功能\n" +
            "# 3.装饰器的返回值是一个函数的对象，该对象就是额外添加功能后与原函数同名的函数\n" +
            "\n" +
            "def outer1(fn):\n" +
            "    def inner():\n" +
            "        print('before')\n" +
            "        fn()\n" +
            "        print('after')\n" +
            "    return inner\n" +
            "@outer1\n" +
            "def sing():\n" +
            "    print('sing')\n" +
            "sing()\n" +
            "\n" +
            "#通用装饰器\n" +
            "\n" +
            "def dec(fn):\n" +
            "    def inner(*args,**kwargs):\n" +
            "        print('before')\n" +
            "        ret = fn(*args,**kwargs)\n" +
            "        print('after')\n" +
            "        return ret\n" +
            "    return inner\n" +
            "@dec\n" +
            "def dance():\n" +
            "    print('xxxx')\n" +
            "    return 100\n" +
            "dance()\n" +
            "\n" +
            "@dec\n" +
            "def dance2(x):\n" +
            "    print('xxxx'+x)\n" +
            "\n" +
            "dance2('fff')",10);
    static Content content20 = new Content("如何理解python中的深拷贝和浅拷贝",".浅拷贝是减少内存的占用（set list dict）\n" +
            "# 2.深拷贝可以在做数据清洗修改入库的时候，对原数据复制一份，以防数据修改之后，找不到原数据，对于不可变对象类型，没有深拷贝和浅拷贝的说法、\n" +
            "# 3.对于可变类型来说，浅拷贝值复制容器，不复制容器中的元素。深拷贝复制容器，元素如果是可变类型，也复制元素\n" +
            "\n" +
            "# 赋值\n" +
            "list1 = [1,2,3]\n" +
            "list2 = list1\n" +
            "list2[0] = 99\n" +
            "print(list1)\n" +
            "print(list2)\n" +
            "#[99, 2, 3] [99, 2, 3]\n" +
            "\n" +
            "#浅拷贝\n" +
            "list1 = [1,2,[3,4]]\n" +
            "list2 = list1.copy()\n" +
            "list2[0] = 99\n" +
            "list2[-1][-1] = 99\n" +
            "print(list1)\n" +
            "print(list2)\n" +
            "#[1, 2, [3, 99]] [99, 2, [3, 99]]\n" +
            "\n" +
            "import copy\n" +
            "#我们改列表中的列表\n" +
            "list1 = [1,2,[3,4]]\n" +
            "list2 = copy.deepcopy(list1)\n" +
            "list2[0] = 99\n" +
            "list2[-1][-1] = 99\n" +
            "print(list1)\n" +
            "print(list2)\n" +
            "#[1, 2, [3, 4]] [99, 2, [3, 99]]",10);
    static Content content21 = new Content("如何在不改变原有list顺序的前提下，去除该list的重复数据","ist1 =[1,2,3,4,5,2,3,2,4,88,2,3,7,9]\n" +
            "#有序\n" +
            "list2 = []\n" +
            "for n in list1:\n" +
            "    if n not in list2:\n" +
            "        list2.append(n)\n" +
            "print(list2)\n" +
            "\n" +
            "#有序\n" +
            "i = 0\n" +
            "while i < len(list1):\n" +
            "    j = i + 1\n" +
            "    while j < len(list1):\n" +
            "        if list1[j] == list1[i]:\n" +
            "            list1.pop(j)\n" +
            "            j -= 1\n" +
            "        j += 1\n" +
            "    i += 1\n" +
            "print(list1)\n" +
            "\n" +
            "#无序的\n" +
            "print(list(set(list1)))",10);
    static Content content22 = new Content("python中classmethod与staticmethod的区别","classmethod是类方法，staticmethod是静态方法，都属于类，为所以对象共有\n" +
            "# classmethod有参数cls，这个参数是类对象，由系统自动传递；staticmethod没有类对象参数\n" +
            "# classmethod在一些工厂类使用比较多，也就是oop继承的时候使用。staticmethod一般可以替换为外部的函数\n" +
            "\n" +
            "class Person:\n" +
            "    def __init__(self,name):\n" +
            "        self.name = name\n" +
            "\n" +
            "    def __eat(self):\n" +
            "        pass\n" +
            "    #对象方法\n" +
            "    def run(self):\n" +
            "        pass\n" +
            "\n" +
            "    #类方法有cls 就是Person类，可以调用类属性，类方法，静态方法\n" +
            "    #可以使用对象和类调用类方法，但是建议使用类来调用\n" +
            "    #类方法中没有self，不能调用对象属性，对象方法，私有方法\n" +
            "    @classmethod\n" +
            "    def sing(cls):\n" +
            "        pass\n" +
            "        print(cls==Person)\n" +
            "        print('classmethod')\n" +
            "\n" +
            "    # 静态方法有没有cls，不可可以调用类属性，类方法，静态方法\n" +
            "    # 可以使用对象和类调用类方法，但是建议使用类来调用\n" +
            "    # 静态方法中没有self，不能调用对象属性，对象方法，私有方法\n" +
            "    @staticmethod\n" +
            "    def dance():\n" +
            "        pass\n" +
            "        print('staticmethod')\n" +
            "\n" +
            "#类名调用\n" +
            "Person.sing()\n" +
            "Person.dance()\n" +
            "\n" +
            "p = Person('name')\n" +
            "p.sing()\n" +
            "p.dance()",10);
    static Content content23 = new Content("请解释python中with关键词的用法","with语句的原理\n" +
            "# 上下文管理协议：包含方法__enter__()和__exit__()支持该协议的对象要实现两个方法\n" +
            "# __enter__()进入代码块之前的准备\n" +
            "# __exit__()退出时的善后操作\n" +
            "#文件对象，线程锁，socjet对象都可以使用with\n" +
            "\n" +
            "#文件打开 自动关闭文件\n" +
            "# with open('a.txt') as fp:\n" +
            "#     pass\n" +
            "\n" +
            "class A:\n" +
            "    def __enter__(self):\n" +
            "        print('enter')\n" +
            "        return self\n" +
            "\n" +
            "    def __exit__(self, exc_type, exc_val, exc_tb):\n" +
            "        print('exit')\n" +
            "        print(exc_type) #异常类型\n" +
            "        print(exc_val) #异常值\n" +
            "        print(exc_tb) #\n" +
            "\n" +
            "with A() as a:\n" +
            "    print(a)\n" +
            "    #抛出异常\n" +
            "    # raise ValueError('hello value')\n" +
            "\n" +
            "# import threading\n" +
            "# lock  =threading.Lock()\n" +
            "# while lock:\n" +
            "#     pass",10);
    static Content content24 = new Content("python中变量在内存中的存储方式","栈区和堆区（内存地址和值）\n" +
            "#可变类型和不可变类型\n" +
            "# 不可变的类型 int float str tuple\n" +
            "# 相同的值指向同一块内存，修改后内存地址变化\n" +
            "# 可变类型 list set dict\n" +
            "# 相同的值指向不同内存，修改后内存地址不变\n" +
            "\n" +
            "s1 = 'hello'\n" +
            "s2 = 'hello'\n" +
            "s3 = 'hello2'\n" +
            "print(id(s1)) #2537331203464\n" +
            "print(id(s2)) #2537331203464\n" +
            "print(id(s3)) #2537331203632\n" +
            "\n" +
            "list1 = [1,2,3]\n" +
            "print(id(list1))\n" +
            "list1.append(4) #1896257226440\n" +
            "print(id(list1))#1896257226440\n" +
            "list2 = [1,2,3]\n" +
            "print(id(list2))#1896256382216",10);
    static Content content25 = new Content("队列和栈两种数据结构的区别和python的实现","#栈\n" +
            "stack = []\n" +
            "#入栈\n" +
            "stack.append(1)\n" +
            "print(stack)\n" +
            "stack.append(2)\n" +
            "stack.append(3)\n" +
            "stack.append(4)\n" +
            "stack.append(5)\n" +
            "print(stack)\n" +
            "#出栈\n" +
            "n = stack.pop()\n" +
            "print(stack)\n" +
            "n = stack.pop()\n" +
            "print(stack)\n" +
            "n = stack.pop()\n" +
            "print(stack)\n" +
            "n = stack.pop()\n" +
            "print(stack)\n" +
            "\n" +
            "#队列\n" +
            "from collections import deque\n" +
            "queue = deque()\n" +
            "print(queue)\n" +
            "\n" +
            "#入队\n" +
            "queue.append(1)\n" +
            "queue.append(2)\n" +
            "queue.append(3)\n" +
            "queue.append(4)\n" +
            "print(queue)\n" +
            "\n" +
            "#出队\n" +
            "queue.popleft()\n" +
            "print(queue)\n" +
            "queue.popleft()\n" +
            "print(queue)\n" +
            "queue.popleft()\n" +
            "print(queue)\n" +
            "queue.popleft()\n" +
            "print(queue)",10);
    static Content content26 = new Content("写出冒泡排序，选择排序，快速排序","sort\n" +
            "\n" +
            "#冒泡排序\n" +
            "#l = [5,3,45,8,6,2,8]\n" +
            "#相互比较,最左边的开始把最大的放到最右边  n-1趟\n" +
            "l = [5,3,45,8,6,2,8]\n" +
            "for i in range(len(l)-1):\n" +
            "    for j in range(len(l)-1-i):\n" +
            "        if l[j] > l[j+1]:\n" +
            "            l[j],l[j+1] = l[j+1],l[j]\n" +
            "print(l)\n" +
            "\n" +
            "#选择排序\n" +
            "#将最小值放在最左边 n-1趟\n" +
            "l = [5,3,45,8,6,2,8]\n" +
            "for i in range(len(l)-1):\n" +
            "    # min_index = l.index(min(l[i:]),i)\n" +
            "    min_index = i\n" +
            "    for j in range(i+1,len(l)):\n" +
            "        if l[j] < l[min_index]:\n" +
            "            min_index = j\n" +
            "    l[i],l[min_index] = l[min_index],l[i]\n" +
            "print(l)\n" +
            "\n" +
            "#快速排序\n" +
            "#列表中选一个数，将小于的这个数的列表房左边，大于这个数的列表放右边，循环这个方式\n" +
            "print('quick_sort')\n" +
            "l = [5,3,45,8,6,2,8]\n" +
            "def quick_sort(l):\n" +
            "    if len(l) < 2:\n" +
            "        return l\n" +
            "\n" +
            "    middle = l.pop(len(l)//2)\n" +
            "    print(middle)\n" +
            "    left = []\n" +
            "    right = []\n" +
            "    for n in l:\n" +
            "        if n< middle:\n" +
            "            left.append(n)\n" +
            "        else:\n" +
            "            right.append(n)\n" +
            "    print(left,[middle],right)\n" +
            "    return quick_sort(left) + [middle] + quick_sort(right)\n" +
            "print(quick_sort(l))",10);
    static Content content27 = new Content("python中高阶函数的认识","map reduce sorted filter zip\n" +
            "\n" +
            "#map 同时处理列表里的多个数据\n" +
            "l1 = [2,3,4,5]\n" +
            "print(list(map(lambda x:x**2,l1)))\n" +
            "print(list(map(lambda x,y:x*y,[1,2,3],[4,5,6])))\n" +
            "\n" +
            "from functools import reduce\n" +
            "#reduce:累加 累乘\n" +
            "def fn(x,y):\n" +
            "    return x*10+y\n" +
            "print(reduce(fn,[3,4,5,6]))\n" +
            "\n" +
            "\n" +
            "#sorted排序\n" +
            "print(sorted(l1))\n" +
            "l3 = [{\"name\":\"111\",\"age\":1},\n" +
            "{\"name\":\"112\",\"age\":133},\n" +
            "{\"name\":\"113\",\"age\":4},\n" +
            "{\"name\":\"114\",\"age\":45},\n" +
            "{\"name\":\"115\",\"age\":6}\n" +
            "]\n" +
            "#升序\n" +
            "print(sorted(l3,key=lambda d:d['age']))\n" +
            "#降序\n" +
            "print(sorted(l3,key=lambda d:d['age'],reverse = True))\n" +
            "\n" +
            "#filter:过滤\n" +
            "l4 = [1,23,4,5,67,8,9,3,6]\n" +
            "print(list(filter(lambda x:x%2==0,l4 )))\n" +
            "\n" +
            "#zip 压缩\n" +
            "l4 = [1,23,4,5,67,8,9,3,6]\n" +
            "#组合\n" +
            "print(list(zip('abcdef',[1,2,3,4,5,6],range(6))))",10);
    static Content content28 = new Content("如何理解python中的封装继承多态","封装：类将属性和方法封装起来 将同一个属性和相同的内容方法放到一个类里面\n" +
            "继承：子类可以继承父类属性的方法 继承将类里面的公共部分提取出来\n" +
            "没有真正类型的多态，重写和重载",10);
    static Content content29 = new Content("python中的内存管理机制是怎样的","引用计数为0的时候就会快速将内存释放\n" +
            "# 1.引用计数\n" +
            "# 2.垃圾回收 GC\n" +
            "# 3.内存池机制 解决了内存碎片影响系统性能\n" +
            "# python内置对象都有独立的内存池\n" +
            "# 当申请内存<256kb，内存主要有python对象\n" +
            "# 当申请内存>256kb,会由c标准库的malloc创建对象\n" +
            "\n" +
            "\n" +
            "#垃圾：占用了但是不会在使用的内存\n" +
            "import sys\n" +
            "list1 = [1,2]\n" +
            "print(sys.getrefcount(list1))\n" +
            "list2 = list1\n" +
            "print(sys.getrefcount(list1))\n" +
            "list2 = 10\n" +
            "print(sys.getrefcount(list1))\n" +
            "list1 = 10\n" +
            "#引用计数为0的时候就会快速将内存释放",10);
    static Content content30 = new Content("谈谈对python进程，线程，携程的理解","1.进程是cpu资源分配的基本单位，线程是独立运行和独立调度的基本单位（cpu真正运行的是线程）\n" +
            "# 2.进程拥有自己的资源空间，一个进程包含若干线程，线程和cpu资源分配无关，多个线程共享一个进程里的资源\n" +
            "# 3.线程的调度和切换比进程快\n" +
            "# 4.cpu密集代码（循环和计算）：使用多进程。IO密集代码（文件处理，网络爬虫）使用多线程\n" +
            "# 5.携程是比线程更轻量级的存在，携程不是由操作系统管理，而是由程序控制。具有高并发，高扩展，低成本的特点。携程很适合处理高并发。通常携程可以处理IO密集型的程序的效率问题，但是处理cpu密集型不是长处。",10);
    static Content content31 = new Content("简述类属性和对象属性的区别","类调用直接得到类属性\n" +
            "#对象属性优先得到对象属性，如果没有对象属性则获得类属性\n" +
            "#类属性是共享的，同一个类共享类属性。对象属性不共享\n" +
            "class Cat:\n" +
            "    #类属性\n" +
            "    name = 'kie'\n" +
            "    age = 2\n" +
            "    likes = ['fish']\n" +
            "\n" +
            "    def __init__(self,name,color):\n" +
            "        # 对象属性\n" +
            "        self.name = name\n" +
            "        self.color = color\n" +
            "        self.likes2 = ['fish']\n" +
            "cat = Cat('xxx','ffff')\n" +
            "print(Cat.age)#2\n" +
            "print(cat.age)#2\n" +
            "print(Cat.name)#kie\n" +
            "print(cat.name)#xxx\n" +
            "# print(Cat.color) 这里不能调用\n" +
            "print(cat.color)#",10);
    static Content content32 = new Content("类中property装饰器有什么用","以调用私有属性的值。将方法属性化\n" +
            "class User:\n" +
            "    def __init__(self,age):\n" +
            "        self.__age = age\n" +
            "    def fn(self):\n" +
            "        return self.__age\n" +
            "\n" +
            "    #调用私有属性，可以做一些判断\n" +
            "    @property\n" +
            "    def age(self):\n" +
            "        return self.__age\n" +
            "\n" +
            "    @property\n" +
            "    def age2(self):\n" +
            "        return self.__age\n" +
            "\n" +
            "    @age.setter\n" +
            "    def age(self,new_age):\n" +
            "        self.__age = new_age\n" +
            "user = User(10)\n" +
            "print(user.fn())\n" +
            "print(user.age)\n" +
            "user.age = 30\n" +
            "print(user.age)",10);
    static Content content33 = new Content("python 输入年月日判断是一年中的第几天","import datetime\n" +
            "\n" +
            "def date_of_year():\n" +
            "    year = int(input('输入年'))\n" +
            "    month = int(input('输入月'))\n" +
            "    day = int(input('输入日'))\n" +
            "    date1 =datetime.date(year=year,month=month,day=day)\n" +
            "    date2 =datetime.date(year=year,month=1,day=1)\n" +
            "    return (date1 - date2).days + 1\n" +
            "\n" +
            "# print(date_of_year())",10);
    static Content content34 = new Content("打乱一个排好序的list对象alist","import random\n" +
            "\n" +
            "alist = [1,2,3,4,5]\n" +
            "random.shuffle(alist)\n" +
            "print(alist)",10);
    static Content content35 = new Content("d= {'a':24,'b':5,'c':36,'d':1}根据value排序","d = {'a':24,'b':5,'c':36,'d':1}\n" +
            "print(list(d.items()))\n" +
            "ret = sorted(d.items(),key=lambda x:x[1])\n" +
            "print(ret)",10);
    static Content content36 = new Content("将字符串 \"k:1 |k2:2|k2:3|k3:4\"处理成字典","s = \"k:1 |k2:2|k2:3|k3:4\"\n" +
            "def str_to_dict(str1):\n" +
            "    dict1 = {}\n" +
            "    for i in str1.split('|'):\n" +
            "        key,value = i.split(\":\")\n" +
            "        dict1[key] = value\n" +
            "    return dict1\n" +
            "ret = str_to_dict(s)\n" +
            "print(ret)\n",10);
    static Content content37 = new Content("写一个列表生成式，产生公差为11的等差数列","print(list(range(0,100,11)))\n",10);
    static Content content38 = new Content("给定两个列表，找出他们相同的元素和不同的元素","list1 = [1,2,3]\n" +
            "list2 = [3,4,5]\n" +
            "set1 = set(list1)\n" +
            "set2 = set(list2)\n" +
            "print(set1 & set2)\n" +
            "print(set1 - set2)",10);
    static Content content39 = new Content("写出一个python代码删除list中的相同元素","list1 = [1,2,3,45,2,3,2,5]\n" +
            "print(list(set(list1)))\n" +
            "\n" +
            "#保证顺序\n" +
            "l2 = list(set(list1))\n" +
            "l2.sort(key=list1.index)\n" +
            "print(l2)",10);
    static Content content40 = new Content("找出整数数组中第二大的数","list1 = [1,24,5,7,4,34,6]\n" +
            "list2  = sorted(set(list1))\n" +
            "print(list2[-2])\n",10);
    static Content content41 = new Content("简述read,readline,readlines区别","read读文件数据多少个\n" +
            "# readline读取1行\n" +
            "# readlines读取所有行\n" +
            "\n" +
            "# with open('file.txt','r',encoding='utf-8') as fp:\n" +
            "#     print(fp.read(30))",10);

    static Content content42 = new Content("手写一个判断函数运行时间的装饰器","import time\n" +
            "def outer(fn):\n" +
            "    def inner(*args,**kwargs):\n" +
            "        t1 = time.time()\n" +
            "        ret = fn(*args,**kwargs)\n" +
            "        t2 = time.time()\n" +
            "        print(t2 - t1)\n" +
            "        return ret\n" +
            "    return inner\n" +
            "\n" +
            "@outer\n" +
            "def test():\n" +
            "    print('xxx')\n" +
            "    time.sleep(0.1)\n" +
            "test()",10);



    static Content content43 = new Content("函数调用参数的方式是值传递还是引用传递","# 不可变参数值传递\n" +
            "# 可变参数的应用传递\n" +
            "n = 100\n" +
            "def fn(n2):\n" +
            "    n2 += 1\n" +
            "    print(n2)#101\n" +
            "fn(n)\n" +
            "print(n)#100\n" +
            "\n" +
            "d = {'age':100}\n" +
            "def fn2(d2):\n" +
            "    d2['age'] += 1\n" +
            "    print(d2) #101\n" +
            "fn2(d)\n" +
            "print(d) #101\n",10);
    static Content content44 = new Content("python中的pass，break，continue,return分别是什么","# pass语法不全相当于空语句\n" +
            "# break跳出循环\n" +
            "# continue跳出一次循环\n" +
            "# return跳出函数\n",10);
    static Content content45 = new Content("如何交换两个变量的值","a = 100\n" +
            "b = 200\n" +
            "a,b = b,a\n" +
            "\n" +
            "c = a\n" +
            "a = b\n" +
            "b = c\n" +
            "\n" +
            "a = a + b\n" +
            "b = a -b\n" +
            "a = a -b",10);
    static Content content46 = new Content("python中回调函数是如何通讯的","#将函数想参数一个的传到另外的函数中\n" +
            "def func(cb):\n" +
            "    print('func')\n" +
            "    ret = cb(8)\n" +
            "    print(ret)\n" +
            "    return ret\n" +
            "#回调函数\n" +
            "callback = lambda x:x*10\n" +
            "\n" +
            "def callback2(x):\n" +
            "    return x*10\n" +
            "\n" +
            "func(callback2)",10);
    static Content content47 = new Content("Python正则表达式中search和match区别","# re.match() 只在字符串的开头进行匹配。\n" +
            "# re.search() 则在整个字符串中查找匹配项，不限于字符串的开头。\n" +
            "\n" +
            "import re\n" +
            "\n" +
            "text = \"Hello, world!\"\n" +
            "\n" +
            "# match() 只在字符串开头查找匹配\n" +
            "result = re.match(r'Hello', text)\n" +
            "print(result)  # <re.Match object; span=(0, 5), match='Hello'>\n" +
            "\n" +
            "result = re.match(r'world', text)\n" +
            "print(result)  # None，因为 'world' 不是字符串的开头\n" +
            "\n" +
            "text = \"Hello, world!\"\n" +
            "\n" +
            "# search() 在整个字符串中查找匹配\n" +
            "result = re.search(r'world', text)\n" +
            "print(result)  # <re.Match object; span=(7, 12), match='world'>\n" +
            "\n" +
            "result = re.search(r'Hello', text)\n" +
            "print(result)  # <re.Match object; span=(0,, 5), match='Hello'>",10);
    static Content content48 = new Content("简述可迭代对象和迭代器直接的区别和联系","1. 可迭代对象 (Iterable)\n" +
            "# 定义: 一个对象是可迭代的，如果它实现了 __iter__() 方法，或者实现了一个返回迭代器的 __getitem__() 方法。简单来说，可迭代对象是可以直接被循环（如 for 循环）遍历的对象。\n" +
            "# 常见的可迭代对象: 常见的包括列表、元组、字符串、字典、集合等。所有这些对象都可以被 for 循环直接遍历。\n" +
            "# 获取迭代器: 使用 iter() 函数可以从一个可迭代对象中获得一个迭代器。\n" +
            "# 2. 迭代器 (Iterator)\n" +
            "# 定义: 一个对象是迭代器，如果它实现了 __iter__() 方法和 __next__() 方法。迭代器是一个表示数据流的对象，提供了一种访问容器对象元素的方式，而不必暴露该对象的内部结构。\n" +
            "# 特点: 迭代器一次只计算一个值（惰性求值），这使得它非常适合处理较大的数据集，因为它不会一次性将所有数据加载到内存中。\n" +
            "# 使用: 可以使用 next() 函数获取迭代器的下一个元素，当迭代器没有更多元素可返回时，会引发 StopIteration 异常。\n" +
            "# 区别:\n" +
            "# 可迭代对象: 是可以返回一个迭代器的对象（比如通过调用 iter() 方法）。\n" +
            "# 迭代器: 是一个具有 __next__() 方法的对象，可以逐个访问可迭代对象中的元素。\n" +
            "# 联系:\n" +
            "# 可迭代对象可以通过调用 iter() 方法返回一个迭代器。\n" +
            "# 迭代器本身也是一个可迭代对象，因为它实现了 __iter__() 方法，并且 __iter__() 返回的正是迭代器对象本身。\n" +
            "# 可迭代对象提供了一个迭代器，可以用来遍历其中的元素。\n" +
            "# 迭代器是通过惰性求值来逐步产生可迭代对象的元素的对象，可以使用 next() 方法来获取下一个元素。",10);
    static Content content49 = new Content("file.txt有10G但是内存只有4G，如果只修改get_lines函数而其他代码保持不变应该怎么实现","#分端读取,也不能分段太多\n" +
            "def get_lines():\n" +
            "    with open('file.txt','rb',encooding='utf-8') as f:\n" +
            "        # return f.readlines()\n" +
            "        #分端读取\n" +
            "        while True:\n" +
            "            part = f.read(10)\n" +
            "            if part:\n" +
            "                yield part\n" +
            "            else:\n" +
            "                return None\n" +
            "\n" +
            "def process(e):\n" +
            "    print('e:',e)\n" +
            "\n" +
            "# if __name__ == '__main__':\n" +
            "#     for e in get_lines():\n" +
            "#         process()\n",10);
    static Content content50 = new Content("补全python代码\n" +
            "import os\n" +
            "def print_directory_contents(sPath):\n" +
            "    \"\"\"\n" +
            "    这个函数接受文件夹的名称作为输出参数\n" +
            "    返回改文件夹中文件路径\n" +
            "    以及包含文件夹中的文件路径\n" +
            "    \"\"\"","import os\n" +
            "def print_directory_contents(sPath):\n" +
            "    \"\"\"\n" +
            "    这个函数接受文件夹的名称作为输出参数\n" +
            "    返回改文件夹中文件路径\n" +
            "    以及包含文件夹中的文件路径\n" +
            "    \"\"\"\n" +
            "    for s_child in os.listdir(sPath):\n" +
            "        s_child_path = os.path.join(sPath,s_child)\n" +
            "        if os.path.isdir(s_child_path):\n" +
            "            print_directory_contents(s_child_path)\n" +
            "        else:\n" +
            "            #文件\n" +
            "            print(s_child_path)\n" +
            "\n" +
            "print_directory_contents(r'D:\\2668')\n",10);
    static Content content51 = new Content("Python中如何实现单例","from functools import wraps\n" +
            "def singleton(fn):\n" +
            "    instance = {}\n" +
            "    @wraps(fn)\n" +
            "    def warpper(*args,**kwargs):\n" +
            "        if fn not  in instance:\n" +
            "            instance[fn] = fn(*args,**kwargs)\n" +
            "        return instance[fn]\n" +
            "    return warpper\n" +
            "\n" +
            "@singleton\n" +
            "class Person:\n" +
            "    pass",10);
    static Content content52 = new Content("不使用中间变量交换俩个变量的值","a = 100\n" +
            "b = 200\n" +
            "a,b = b,a\n" +
            "\n" +
            "a = a + b\n" +
            "b = a - b\n" +
            "a = a -b\n" +
            "\n" +
            "a = a^b\n" +
            "b = a^b\n" +
            "a = a^b\n",10);
    static Content content53 = new Content("写一个删除列表中重复的元素的函数，要求去重后元素相对位置保持不变","list1 = [1,2,34,34,56,2,12,45,1,15]\n" +
            "list2 = []\n" +
            "for i in list1:\n" +
            "    if i not in list2:\n" +
            "        list2.append(i)\n" +
            "\n" +
            "print(list2)\n",10);
    static Content content54 = new Content("运行结果 Cpython\n" +
            "a,b,c,d = 1,1,1000,1000\n" +
            "print(a is b,c is d)\n" +
            "def foo():\n" +
            "    e = 1000\n" +
            "    f =1000\n" +
            "    print(e is f ,e is d)\n" +
            "    g = 1\n" +
            "    print(g is a)\n" +
            "foo()","#小于256在内存里有独立的空间的\n" +
            "# True False\n" +
            "#在代码块中，或者说在函数中不会重复创建\n" +
            "# True False\n" +
            "# True",10);
    static Content content55 = new Content("lambda函数是什么，举例说明它的应用场景","# Lambda 表达式 是一种简洁的定义匿名函数的方法，通常用于需要短小函数的地方。\n" +
            "# 虽然 lambda 提供了简洁性，但它只适用于简单的操作。对于复杂的逻辑，仍然应使用常规的函数定义方式。\n" +
            "#lambda 参数1, 参数2, ... : 表达式\n" +
            "# 使用 lambda 表达式对列表中的每个元素平方\n" +
            "squared = list(map(lambda x: x ** 2, [1, 2, 3, 4]))\n" +
            "print(squared)  # 输出: [1, 4, 9, 16]\n" +
            "\n" +
            "# 使用 lambda 表达式根据列表中元组的第二个元素排序\n" +
            "pairs = [(1, 'one'), (2, 'two'), (3, 'three')]\n" +
            "pairs.sort(key=lambda pair: pair[1])\n" +
            "print(pairs)  # 输出: [(1, 'one'), (3, 'three'), (2, 'two')]",10);
    static Content content56 = new Content("迭代器和生成器的理解","迭代器 是一个对象，具有 __iter__() 和 __next__() 方法，用于遍历数据结构中的元素。\n" +
            "# 生成器 是一种特殊的迭代器，通过 yield 语句生成元素，更易于实现复杂的迭代逻辑，且非常高效。\n" +
            "# 生成器在Python中广泛用于处理大型数据集、流式数据以及需要节省内存的场景。\n" +
            "my_list = [1, 2, 3]\n" +
            "iterator = iter(my_list)\n" +
            "\n" +
            "print(next(iterator))  # 输出 1\n" +
            "print(next(iterator))  # 输出 2\n" +
            "print(next(iterator))  # 输出 3\n" +
            "\n" +
            "def simple_generator():\n" +
            "    yield 1\n" +
            "    yield 2\n" +
            "    yield 3\n" +
            "\n" +
            "gen = simple_generator()\n" +
            "print(next(gen))  # 输出 1\n" +
            "print(next(gen))  # 输出 2\n" +
            "print(next(gen))  # 输出 3\n" +
            "\n" +
            "gen = (x * x for x in range(3))\n" +
            "print(gen)\n" +
            "print(next(gen))  # 输出 0\n" +
            "print(next(gen))  # 输出 1\n" +
            "print(next(gen))  # 输出 4",10);
    static Content content57 = new Content("程序运行结果是\n" +
            "def multiply():\n" +
            "    return [lambda x:i*x for i in range(4)]\n" +
            "print([m(100) for m in multiply()])\n","[300,300,300,300]",10);


    static Content content58  = new Content("Python为什么没有重载","python是动态类型语言，没有参数的约束，可以用可变参数和关键字参数，也可以用functools.singledispatch实现类似的功能",10);

    public static void setContents(){
        SelfData.contents.add(content1);
        SelfData.contents.add(content2);
        SelfData.contents.add(content3);
        SelfData.contents.add(content4);
        SelfData.contents.add(content5);
        SelfData.contents.add(content6);
        SelfData.contents.add(content7);
        SelfData.contents.add(content8);
        SelfData.contents.add(content9);
        SelfData.contents.add(content10);
        SelfData.contents.add(content11);
        SelfData.contents.add(content12);
        SelfData.contents.add(content13);
        SelfData.contents.add(content14);
        SelfData.contents.add(content15);
        SelfData.contents.add(content16);
        SelfData.contents.add(content17);
        SelfData.contents.add(content18);
        SelfData.contents.add(content19);
        SelfData.contents.add(content20);
        SelfData.contents.add(content21);
        SelfData.contents.add(content22);
        SelfData.contents.add(content23);
        SelfData.contents.add(content24);
        SelfData.contents.add(content25);
        SelfData.contents.add(content26);
        SelfData.contents.add(content27);
        SelfData.contents.add(content28);
        SelfData.contents.add(content29);
        SelfData.contents.add(content30);
        SelfData.contents.add(content31);
        SelfData.contents.add(content32);
        SelfData.contents.add(content33);
        SelfData.contents.add(content34);
        SelfData.contents.add(content35);
        SelfData.contents.add(content36);
        SelfData.contents.add(content37);
        SelfData.contents.add(content38);
        SelfData.contents.add(content39);
        SelfData.contents.add(content40);
        SelfData.contents.add(content41);
        SelfData.contents.add(content42);
        SelfData.contents.add(content43);
        SelfData.contents.add(content44);
        SelfData.contents.add(content45);
        SelfData.contents.add(content46);
        SelfData.contents.add(content47);
        SelfData.contents.add(content48);
        SelfData.contents.add(content49);
        SelfData.contents.add(content50);
        SelfData.contents.add(content51);
        SelfData.contents.add(content52);
        SelfData.contents.add(content53);
        SelfData.contents.add(content54);
        SelfData.contents.add(content55);
        SelfData.contents.add(content56);
        SelfData.contents.add(content57);
        SelfData.contents.add(content58);

    }

}
