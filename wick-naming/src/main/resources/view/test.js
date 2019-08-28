$(document).ready(function() {
    layui.use(['layer', 'form', 'element', 'laypage', 'upload', 'tree', 'carousel', 'flow'], function(){
        var layer = layui.layer
            ,form = layui.form
            ,element = layui.element
            ,$ = layui.jquery
            ,laypage = layui.laypage
            ,upload = layui.upload
            ,tree = layui.tree
            ,carousel = layui.carousel
            ,flow = layui.flow;

        //TODO  do something
        //监听提交
        form.on('submit(submitForm)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        $('#userInfo').on('click', function () {
            // layer.open({
            //     type: 1,
            //     content: '传入任意的文本或html'
            // });
            //
            layer.open({
                type: 2,
                content: 'http://sentsin.com' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            });
        });



        //触发事件
        var active = {
            tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };

        var tablePage = laypage.render({
            elem: 'test1'
            ,count: 1000
            ,limit: 100
            ,limits: [100, 300, 500]
        });

        //执行实例
        var uploadInst = upload.render({
            elem: '#uploadFile' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                layer.alert("回调完毕");
            }
            ,error: function(){
                layer.alert("回调异常");
            }
        });

        //渲染
        var treeTest = tree.render({
            elem: '#treeTest'
            ,data: [{
                title: '成都' //一级菜单
                ,children: [{
                    title: '金牛区' //二级菜单
                    ,children: [{
                        title: '环球广场' //三级菜单
                        ,children: [{
                            title: '爱达乐' //三级菜单
                            //…… //以此类推，可无限层级
                        }]
                    }]
                }]
            },{
                title: '重庆'
            }]
            ,click: function(obj){
                console.log(obj.data); //得到当前点击的节点数据
                console.log(obj.state); //得到当前节点的展开状态：open、close、normal
                console.log(obj.elem); //得到当前节点元素
                console.log(obj.data.children); //当前节点下是否有子节点
            }
            ,oncheck: function(obj){
                console.log(obj.data); //得到当前点击的节点数据
                console.log(obj.checked); //得到当前节点的展开状态：open、close、normal
                console.log(obj.elem); //得到当前节点元素
            }
        });

        carousel.render({
            elem: '#carouse'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });

        flow.load({
            elem: '#flowTest' //指定列表容器
            ,scrollElem: '.menu-botR'
            ,done: function(page, next) { //到达临界点（默认滚动触发），触发下一页
                //模拟数据插入
                setTimeout(function(){
                    var lis = [];
                    for(var i = 0; i < 3; i++){
                        lis.push('<li>'+ ( (page-1)*8 + i + 1 ) +'</li>')
                    }

                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < 4 ); //假设总页数为 10
                }, 500);
            }
            ,end:'到底了！'
        });

        //按屏加载图片
        flow.lazyimg({
            elem: '#flowImageTest img'
        });
    });
}