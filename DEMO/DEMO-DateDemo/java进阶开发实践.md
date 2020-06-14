### ### 一.java日期类
 #### (一)jdk1.8之前：
##### （1）java.util.Date
（1）Date类：java.util 包提供了 Date 类来封装当前的日期和时间。

（2）构造方法：
        
        1.Date():分配 Date 对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
    2.Date(long date)：分配一个Date对象，并将其初始化为表示从标准基准时间起指定的毫秒数。
（3）其他方法：
    
    1.boolean after(Date date):若当调用此方法的Date对象在指定日期之后返回true,否则返回false。
    2.boolean before(Date date):若当调用此方法的Date对象在指定日期之前返回true,否则返回false。
    3.Object clone( ):返回此对象的副本。
    4.int compareTo(Date date):比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。
    5.int compareTo(Object obj):若obj是Date类型则操作等同于compareTo(Date) 。否则它抛出ClassCastException。
    6.boolean equals(Object date):当调用此方法的Date对象和指定日期相等时候返回true,否则返回false。
    7.long getTime( ):返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
    8.int hashCode( ):返回此对象的哈希码值。
    9.void setTime(long time):用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。
    10.String toString( ):把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。
##### （2）java.util.Calendar
（1）Calendar：日历类，也是一个抽象类，为某一时刻和一组日历字段之间的转换提供了一些方法，并未操作日历字段提供了一些方法。
    
（2）由于Calendar是抽象类，不能直接创建对象，所以Calendar提供了一个类方法getInstance用于获取Calendar对象。Calendar   calendar=Calendar.getInstance();

（3）日历类常用方法：
    
    1.通过calendar可以调用下面的方法将日历翻到指定的一个时间。
        void set(int year,int month,int date);
        void set(int year,int month,int date,int hour,int minute);
        void set(int year,int month,int date,int hour,int minute,int second);
    2.若要调用有关年份、月份、小时、星期等信息，可以通过调用下面的方法实现：
        int get(int field);
        其中，参数 field 的值由 Calendar 类的静态常量决定。其中：YEAR 代表年，MONTH 代表月，HOUR 代表小时，MINUTE 代表分，如：
        calendar.get(Calendar.MONTH);
    3.public abstract void add（int filed，int amount）;根据日历规则，将指定的时间量添加或减去给定的日历字段。

    4.其他常用方法见API，java.uitl.Calender类

##### （3）java.text.SimpleDateFormat
（1）SimpleDateFormat类：是一个以语言环境敏感的方式来格式化和分析日期的类。

（2）SimpleDateFormate是线程不安全的类，其父类维护了一个Calendar,调用相关方法有可能会修改Calendar。一般不要定义为static变量，如果定义为 static，必须加锁，或者使用 DateUtils 工具类。

（3）常用方法：
    
    1.格式化（从Date到String）：
        public final String format（Date date）；将日期格式转化为日期字符串。
    2.解析（从String到Date）：
        public Date parse（String source）；从给定的字符串解析文本以生成日期。
    3.其余方法看API。
#### （二）jdk1.8：
##### （1）jdk1.8增加了新的date.time包，核心代码主要放在java.time包下。
##### （2）java.time主要内容：
（1）java.time：主要包括日期，时间，日期时间，时刻，期间，和时钟相关的类。

（2）java.time.format：格式化和解析日期时间的类。

（3）java.time.temporal扩展API，主要是提供给写框架和写库的人，允许日期时间相互操作，访问，和调整。字段和单位在这个包下定义。

（4）java.time.zone -定义了时区，相对于时区的偏移量，时区规则等。
##### （3）jdk1.8日期中时间api没有并发问题。
##### （4）相互转化和Instant：
    老的时间日期类里面都有了Instant的转化。Instant可以说是新旧转换的中转站。Instant主要维护了秒和纳秒字段，可以表示纳秒范围。当然不支持的话会抛出异常。主要还是java.util.Date转换成新的时间类。
            
##### （5）Clock
    提供了访问当前时间的方法，也可以获取当前Instant。Clock是持有时区或者时区偏移量的。如果只是获取当前时间戳，推荐还是用System.currentTimeMillis()

##### （6）DateTimeFormatter：时间对象进行格式化时间的需要用到格式化和解析日期和时间的时候需要用到DateTimeFormatter。

### 二.File类
#### （一）File类概述：
##### （1）在jdk1.8API 中就已经告诉了我们File应该理解成路径，而不是文件。
##### （2）路径类别：路径包括文件夹路径和文件路径，又可以分为绝对路径和相对路径。
（1）绝对路径：就是指带上盘符的完整文件路径。

（2）相对路径：是该文件和当前Java项目根目录在同一个文件夹。
#### （二）File构造方法
##### （1）File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。 
##### （2）File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
##### （3）File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。 
##### （4）File(URI uri) ：通过将给定的 file: URI转换为抽象路径名来创建新的 File实例。
#### （三）File类对文件操作的方法
##### （1）public boolean creatNewFile():创建文件，如果存在这样的文件，就不创建。
##### （2）public boolean mkdir():创建文件夹，如果存在这样的文件夹，就不创建。
##### （3）public boolean mkdirs():创建文件夹，如果父文件夹不存在，就帮你创建出来。
##### （4） public String getAbsolutePath():获取绝对路径
##### （5）public String getName()：返回由此抽象路径名表示的文件或目录的名称
##### （6）public String[] list():获取指定目录下的所有文件或文件夹的名称

### 三.正则表达式
#### （一）什么是正则表达式
##### （1）定义：正则表达式描述了一种字符串匹配的模式，可以用来检查一个串是否含有某种子串、将匹配的子串做替换或者从某个串中取出符合某个条件的子串等。构造正则表达式的方法和创建数学表达式的方法一样。也就是用多种元字符与运算符可以将小的表达式结合在一起来创建更大的表达式。正则表达式的组件可以是单个的字符、字符集合、字符范围、字符间的选择或者所有这些组件的任意组合。
##### （2）组成：由普通字符（例如字符 a 到 z）以及特殊字符（称为"元字符"）组成的文字模式。模式描述在搜索文本时要匹配的一个或多个字符串。正则表达式作为一个模板，将某个字符模式与所搜索的字符串进行匹配。
##### （3）何时使用：
（1）验证——从头到尾完整匹配！

（2）查找——只要部分匹配即可！
#### （二）基础语法和规则
##### （1）备选字符集：规定某一位字符可用的备选字符的集合。
（1）语法：[可选字符列表]

（2）注意：
    
    1.无论备选字符集包含多少字符，只能选1个.
    2.必须选1个！
#####  （2）预定义字符集：为常用的字符集专门提供的简化写法！
##### （3）数量词：规定相邻的字符集可出现的次数。
（1）确定数量：
    
    1.{n}--> 必须反复出现n位。
    2.{n,m}--> 最少出现n次，最多出现m次
    3.{n,}-->至少出现n次，多了不限！
（2)不确定数量：
    
    1.*: 有没有都行，次数不限，相当于{0,}
    2.+: 至少1次，重复次数不限，相当于{1,}
    3.?: 有没有都行，最多1次,相当于{0,1}
    4.  ():分组
    5.|: 左右两正则表达式选其一
    
##### （4）指定匹配位置
（1）^表达式: 必须以表达式的规则为开头

（2）表达式$: 必须以表达式的规则为结尾

（3）*预告：今后只要在程序中执行验证：都要前加^后加$*表示从头到尾完整匹配。
##### （5）预判：在正式匹配正则表达式之前，先预读整个字符串，进行初步匹配，如果预判都未通过，则不再验证！
（1）(?=表达式): 先浏览字符串是否满足表达式的要求
    
    1.何时使用：只要正则中出现类似"而且"
（2）(?!表达式):先检查字符串是否不满足表达式要求

