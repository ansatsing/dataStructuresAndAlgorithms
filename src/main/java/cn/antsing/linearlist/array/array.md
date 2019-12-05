# 数组
- 初始化时就定义了数组长度
- 存储都是相同类型的数据
- 内存空间是连续的
- 可存储基本类型
# ArrayList
- 存储的数据肯定是连续的，中间不会出现空洞
- 只能存储引用类型
- 不能从末位夸2个位添加数据
```
        List<Integer> list = new ArrayList<>(10);
        list.addAll(Arrays.asList(1,2,3,4,5));
        //list.add(5,9);//不报错
        list.add(6,9);//java.lang.IndexOutOfBoundsException: Index: 6, Size: 5
        
```


# 时间复杂度分析
- 按下标获取数据的时间复杂度为O(1)
- 非排序数组查找数据的时间复杂度为O(n)
- 排序数组的查找数据的时间复杂度为O(logn)