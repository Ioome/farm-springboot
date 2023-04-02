
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '公告信息',
	url: './pages/gonggaoxinxi/list.html'
}, 
{
	name: '区块',
	url: './pages/qukuai/list.html'
}, 
{
	name: '植物',
	url: './pages/zhiwu/list.html'
}, 
{
	name: '种植',
	url: './pages/zhongzhi/list.html'
}, 
{
	name: '换水',
	url: './pages/huanshui/list.html'
}, 
{
	name: '环境',
	url: './pages/huanjing/list.html'
}, 

{
	name: '新闻资讯',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/springbootae935/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"区块","menuJump":"列表","tableName":"qukuai"}],"menu":"区块管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"植物","menuJump":"列表","tableName":"zhiwu"}],"menu":"植物管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"种植","menuJump":"列表","tableName":"zhongzhi"}],"menu":"种植管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"换水","menuJump":"列表","tableName":"huanshui"}],"menu":"换水管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"环境","menuJump":"列表","tableName":"huanjing"}],"menu":"环境管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"buttons":["新增","查看","修改","删除"],"menu":"新闻资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"buttons":["查看","种植"],"menu":"区块列表","menuJump":"列表","tableName":"qukuai"}],"menu":"区块模块"},{"child":[{"buttons":["查看"],"menu":"植物列表","menuJump":"列表","tableName":"zhiwu"}],"menu":"植物模块"},{"child":[{"buttons":["查看","环境","换水"],"menu":"种植列表","menuJump":"列表","tableName":"zhongzhi"}],"menu":"种植模块"},{"child":[{"buttons":["查看"],"menu":"换水列表","menuJump":"列表","tableName":"huanshui"}],"menu":"换水模块"},{"child":[{"buttons":["查看"],"menu":"环境列表","menuJump":"列表","tableName":"huanjing"}],"menu":"环境模块"}],"roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"buttons":["查看"],"menu":"区块","menuJump":"列表","tableName":"qukuai"}],"menu":"区块管理"},{"child":[{"buttons":["查看"],"menu":"植物","menuJump":"列表","tableName":"zhiwu"}],"menu":"植物管理"},{"child":[{"buttons":["查看"],"menu":"种植","menuJump":"列表","tableName":"zhongzhi"}],"menu":"种植管理"},{"child":[{"buttons":["查看"],"menu":"换水","menuJump":"列表","tableName":"huanshui"}],"menu":"换水管理"},{"child":[{"buttons":["查看"],"menu":"环境","menuJump":"列表","tableName":"huanjing"}],"menu":"环境管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"buttons":["查看","种植"],"menu":"区块列表","menuJump":"列表","tableName":"qukuai"}],"menu":"区块模块"},{"child":[{"buttons":["查看"],"menu":"植物列表","menuJump":"列表","tableName":"zhiwu"}],"menu":"植物模块"},{"child":[{"buttons":["查看","环境","换水"],"menu":"种植列表","menuJump":"列表","tableName":"zhongzhi"}],"menu":"种植模块"},{"child":[{"buttons":["查看"],"menu":"换水列表","menuJump":"列表","tableName":"huanshui"}],"menu":"换水模块"},{"child":[{"buttons":["查看"],"menu":"环境列表","menuJump":"列表","tableName":"huanjing"}],"menu":"环境模块"}],"roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
