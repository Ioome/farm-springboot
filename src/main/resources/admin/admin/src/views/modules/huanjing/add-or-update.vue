<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="编号" prop="bianhao">
          <el-input v-model="ruleForm.bianhao" 
              placeholder="编号" clearable  :readonly="ro.bianhao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="编号" prop="bianhao">
              <el-input v-model="ruleForm.bianhao" 
                placeholder="编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="土地名称" prop="tudimingcheng">
          <el-input v-model="ruleForm.tudimingcheng" 
              placeholder="土地名称" clearable  :readonly="ro.tudimingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="土地名称" prop="tudimingcheng">
              <el-input v-model="ruleForm.tudimingcheng" 
                placeholder="土地名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="植物名称" prop="zhiwumingcheng">
          <el-input v-model="ruleForm.zhiwumingcheng" 
              placeholder="植物名称" clearable  :readonly="ro.zhiwumingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="植物名称" prop="zhiwumingcheng">
              <el-input v-model="ruleForm.zhiwumingcheng" 
                placeholder="植物名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="分类" prop="fenlei">
          <el-input v-model="ruleForm.fenlei" 
              placeholder="分类" clearable  :readonly="ro.fenlei"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="分类" prop="fenlei">
              <el-input v-model="ruleForm.fenlei" 
                placeholder="分类" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.zhiwutupian" label="植物图片" prop="zhiwutupian">
          <file-upload
          tip="点击上传植物图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhiwutupian?ruleForm.zhiwutupian:''"
          @change="zhiwutupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhiwutupian" label="植物图片" prop="zhiwutupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.zhiwutupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="种植日期" prop="zhongzhiriqi">
          <el-input v-model="ruleForm.zhongzhiriqi" 
              placeholder="种植日期" clearable  :readonly="ro.zhongzhiriqi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="种植日期" prop="zhongzhiriqi">
              <el-input v-model="ruleForm.zhongzhiriqi" 
                placeholder="种植日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="当前状态" prop="dangqianzhuangtai">
          <el-input v-model="ruleForm.dangqianzhuangtai" 
              placeholder="当前状态" clearable  :readonly="ro.dangqianzhuangtai"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="当前状态" prop="dangqianzhuangtai">
              <el-input v-model="ruleForm.dangqianzhuangtai" 
                placeholder="当前状态" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="环境温度" prop="huanjingwendu">
          <el-input v-model="ruleForm.huanjingwendu" 
              placeholder="环境温度" clearable  :readonly="ro.huanjingwendu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="环境温度" prop="huanjingwendu">
              <el-input v-model="ruleForm.huanjingwendu" 
                placeholder="环境温度" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="温度建议" prop="wendujianyi">
          <el-input v-model="ruleForm.wendujianyi" 
              placeholder="温度建议" clearable  :readonly="ro.wendujianyi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="温度建议" prop="wendujianyi">
              <el-input v-model="ruleForm.wendujianyi" 
                placeholder="温度建议" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="温度管理" prop="wenduguanli">
          <el-select v-model="ruleForm.wenduguanli" placeholder="请选择温度管理">
            <el-option
                v-for="(item,index) in wenduguanliOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="温度管理" prop="wenduguanli">
	      <el-input v-model="ruleForm.wenduguanli"
                placeholder="温度管理" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="空气湿度" prop="kongqishidu">
          <el-input v-model="ruleForm.kongqishidu" 
              placeholder="空气湿度" clearable  :readonly="ro.kongqishidu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="空气湿度" prop="kongqishidu">
              <el-input v-model="ruleForm.kongqishidu" 
                placeholder="空气湿度" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="湿度建议" prop="shidujianyi">
          <el-input v-model="ruleForm.shidujianyi" 
              placeholder="湿度建议" clearable  :readonly="ro.shidujianyi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="湿度建议" prop="shidujianyi">
              <el-input v-model="ruleForm.shidujianyi" 
                placeholder="湿度建议" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="土壤管理" prop="turangguanli">
          <el-select v-model="ruleForm.turangguanli" placeholder="请选择土壤管理">
            <el-option
                v-for="(item,index) in turangguanliOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="土壤管理" prop="turangguanli">
	      <el-input v-model="ruleForm.turangguanli"
                placeholder="土壤管理" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="其它" prop="qita">
          <el-input v-model="ruleForm.qita" 
              placeholder="其它" clearable  :readonly="ro.qita"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="其它" prop="qita">
              <el-input v-model="ruleForm.qita" 
                placeholder="其它" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="手机" prop="shouji">
              <el-input v-model="ruleForm.shouji" 
                placeholder="手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                            </el-row>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(252, 201, 51, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"rgba(220, 223, 230, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(81, 81, 81, 1)","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"0px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	bianhao : false,
	tudimingcheng : false,
	zhiwumingcheng : false,
	fenlei : false,
	zhiwutupian : false,
	zhongzhiriqi : false,
	dangqianzhuangtai : false,
	huanjingwendu : false,
	wendujianyi : false,
	wenduguanli : false,
	kongqishidu : false,
	shidujianyi : false,
	turangguanli : false,
	qita : false,
	yonghuming : false,
	shouji : false,
	userid : false,
      },
            ruleForm: {
                	        bianhao: '',
	                        	        tudimingcheng: '',
	                        	        zhiwumingcheng: '',
	                        	        fenlei: '',
	                        	        zhiwutupian: '',
	                        	        zhongzhiriqi: '',
	                        	        dangqianzhuangtai: '',
	                        	        huanjingwendu: '',
	                        	        wendujianyi: '',
	                        	        wenduguanli: '',
	                        	        kongqishidu: '',
	                        	        shidujianyi: '',
	                        	        turangguanli: '',
	                        	        qita: '',
	                        	        yonghuming: '',
	                        	        shouji: '',
	                        	        userid: '',
	                      },
                                                                                                                                                      wenduguanliOptions: [],
                                                            turangguanliOptions: [],
                                                                            rules: {
                  bianhao: [
                                    	                                                              ],
                  tudimingcheng: [
                                    	                                                              ],
                  zhiwumingcheng: [
                                    	                                                              ],
                  fenlei: [
                                    	                                                              ],
                  zhiwutupian: [
                                    	                                                              ],
                  zhongzhiriqi: [
                                    	                                                              ],
                  dangqianzhuangtai: [
                                    	                                                              ],
                  huanjingwendu: [
                            { required: true, message: '环境温度不能为空', trigger: 'blur' },
                                    	                                                              ],
                  wendujianyi: [
                                    	                                                              ],
                  wenduguanli: [
                                    	                                                              ],
                  kongqishidu: [
                            { required: true, message: '空气湿度不能为空', trigger: 'blur' },
                                    	                                                              ],
                  shidujianyi: [
                                    	                                                              ],
                  turangguanli: [
                                    	                                                              ],
                  qita: [
                                    	                                                              ],
                  yonghuming: [
                                    	                                                              ],
                  shouji: [
                                    	                                                              ],
                  userid: [
                            { required: true, message: '用户id不能为空', trigger: 'blur' },
                                    	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                                                                                                  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='bianhao'){
            this.ruleForm.bianhao = obj[o];
	    this.ro.bianhao = true;
            continue;
          }
	            	            if(o=='tudimingcheng'){
            this.ruleForm.tudimingcheng = obj[o];
	    this.ro.tudimingcheng = true;
            continue;
          }
	            	            if(o=='zhiwumingcheng'){
            this.ruleForm.zhiwumingcheng = obj[o];
	    this.ro.zhiwumingcheng = true;
            continue;
          }
	            	            if(o=='fenlei'){
            this.ruleForm.fenlei = obj[o];
	    this.ro.fenlei = true;
            continue;
          }
	            	            if(o=='zhiwutupian'){
            this.ruleForm.zhiwutupian = obj[o];
	    this.ro.zhiwutupian = true;
            continue;
          }
	            	            if(o=='zhongzhiriqi'){
            this.ruleForm.zhongzhiriqi = obj[o];
	    this.ro.zhongzhiriqi = true;
            continue;
          }
	            	            if(o=='dangqianzhuangtai'){
            this.ruleForm.dangqianzhuangtai = obj[o];
	    this.ro.dangqianzhuangtai = true;
            continue;
          }
	            	            if(o=='huanjingwendu'){
            this.ruleForm.huanjingwendu = obj[o];
	    this.ro.huanjingwendu = true;
            continue;
          }
	            	            if(o=='wendujianyi'){
            this.ruleForm.wendujianyi = obj[o];
	    this.ro.wendujianyi = true;
            continue;
          }
	            	            if(o=='wenduguanli'){
            this.ruleForm.wenduguanli = obj[o];
	    this.ro.wenduguanli = true;
            continue;
          }
	            	            if(o=='kongqishidu'){
            this.ruleForm.kongqishidu = obj[o];
	    this.ro.kongqishidu = true;
            continue;
          }
	            	            if(o=='shidujianyi'){
            this.ruleForm.shidujianyi = obj[o];
	    this.ro.shidujianyi = true;
            continue;
          }
	            	            if(o=='turangguanli'){
            this.ruleForm.turangguanli = obj[o];
	    this.ro.turangguanli = true;
            continue;
          }
	            	            if(o=='qita'){
            this.ruleForm.qita = obj[o];
	    this.ro.qita = true;
            continue;
          }
	            	            if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
	    this.ro.yonghuming = true;
            continue;
          }
	            	            if(o=='shouji'){
            this.ruleForm.shouji = obj[o];
	    this.ro.shouji = true;
            continue;
          }
	            	            if(o=='userid'){
            this.ruleForm.userid = obj[o];
	    this.ro.userid = true;
            continue;
          }
	                    }
                                                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                                                                                                                                                                                        this.ruleForm.yonghuming = json.yonghuming
                                                this.ruleForm.shouji = json.shouji
                                                    } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                            this.wenduguanliOptions = "制热,制冷".split(',')
                                                                            this.turangguanliOptions = "干燥,加湿".split(',')
                                                                                                    },
                                                                                                                                                // 多级联动参数
                                                                                                                                                                                      info(id) {
      this.$http({
        url: `huanjing/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                                                      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `huanjing/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.huanjingCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.huanjingCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                                        zhiwutupianUploadChange(fileUrls) {
                this.ruleForm.zhiwutupian = fileUrls;
				this.addEditUploadStyleChange()
            },
                                                                                                                                                            	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
