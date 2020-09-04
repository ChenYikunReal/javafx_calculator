# JavaFX计算器

![在这里插入图片描述](https://github.com/ChenYikunReal/javafx_calculator/blob/master/images/javafx-vs-swing.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg5NjMxOA==,size_16,color_FFFFFF,t_70)


这是我第一次使用JavaFX，以前的GUI一般是用Swing写，显然JavaFX是优于Swing的，只是可惜并没有得到广泛的应用。

项目结构是直接使用IDEA建立的，但没有使用Controller和fxml，毕竟明天就要返校了呜呜呜\~\~\~


运行时是这个样子的：


![在这里插入图片描述](https://github.com/ChenYikunReal/javafx_calculator/blob/master/images/javafx-calculator.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg5NjMxOA==,size_16,color_FFFFFF,t_70)


## 未完成的功能
- `?`空按钮的填充(可以增加根号等)
- `CE`和`C`的区分
- `Mc`、`Mr`、`M+`、`M-`、`Ms`的功能
- 小数点`.`和小数功能的支持(当前无效)
- `%`功能
- 多次按`=`的连续运算
- 其他细节问题

## 计算器按键说明

### CE和C的区别
CE在正常计算时可以用于清除当前寄存器数值并在显示器上显示0。<br/>
在计算机计算结果超出可显示容量时，计算器会报错，这时按CE键可以消除报错，显示屏上保持显示被省略后的结果。<br/>
它和C键的区别在于CE键不清除存储（如M+、GT键的存储，就是累加、累减之类的存储）一般情况下使用，没有区别。 <br/>

### M+、M-、Mr等到底是啥
- MC：清除储存数据
- MR：读取储存的数据
- M-：用已存的数值减去当前显示的数值后，再将结果保存
- M+：用已存的数值加上当前显示的数值后，再将结果保存
- ……

### %的说明
这里的`%`不是取模，而是百分号，其用法是这样的（举个栗子）：
```text
20-100% = 20-(20*100%) = 20-20 = 0

20-50% = 20-(20*50%) = 20-10 = 10

50*50% = 50*0.5 = 25
```
可见：
- 对于加减运算，百分号相当于将数值2变为数值1的对应百分比数值，然后运算
- 对于乘除运算，百分号相当于将数值2变为对应的百分比数值，然后运算
