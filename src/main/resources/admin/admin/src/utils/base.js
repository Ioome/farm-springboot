const base = {
    get() {
                return {
            url : "http://localhost:8080/springbootae935/",
            name: "springbootae935",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootae935/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "智慧农场数据存储与管理"
        } 
    }
}
export default base
