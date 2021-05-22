<template>
  <!-- 准备根标签-->
  <div>

      <!-- 1.编辑面包屑导航 -->
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
      </el-breadcrumb>

      <!-- 2.定义卡片标签 -->
      <el-card class="box-card">

        <!-- 2.1 定义一行元素 -->
        <el-row :gutter="20">

          <el-col :span="9">
            <!-- 2.2定义用户的输入框 -->
             <el-input placeholder="请输入内容" v-model="queryInfo.query" class="input-with-select"
             clearable @clear="getUserList">
                <el-button slot="append" icon="el-icon-search" @click="getUserList"></el-button>
             </el-input>
          </el-col>

          <el-col :span="4">
            <!-- 2.2 定义新增用户按钮-->
            <el-button type="primary" @click="addUserDialogVisible = true">添加用户</el-button>
          </el-col>
        </el-row>



        <!-- 定义表格数据
           :data: 表格的数据来源
           prop:  从userList中获取的属性值
           label: 字段名称
           stripe: 斑马纹效果
           border: 列
        -->
         <el-table :data="userList" style="width: 100%" stripe  border>
            <el-table-column prop="username" label="用户名"></el-table-column>
            <el-table-column prop="phone" label="电话"></el-table-column>
            <el-table-column prop="email" label="邮箱"></el-table-column>
            <el-table-column prop="status" label="状态">
              <template slot-scope="scope">
                  <!-- scope封装的对象 获取行级元素 row属性实现 -->
                  <el-switch v-model="scope.row.status" @change="updateStatus(scope.row)"
                    active-color="#13ce66"  inactive-color="#ff4949">
                  </el-switch>
              </template>
            </el-table-column>
            <el-table-column label="操作">

              <template slot-scope="scope">
                <el-button type="primary" icon="el-icon-edit" size="small"></el-button>
                <el-button type="danger" icon="el-icon-delete" size="small" @click="deleteUser(scope.row)"></el-button>
              </template>

            </el-table-column>
         </el-table>

        <!-- 3.定义分页功能
           1.@size-change  当页面的条数变化时触发
           2.@current-change  当页数改变时触发
           3.current-page  显示当前的页数 ??
           4.:page-sizes   显示页数的数组
           5.page-size     初始条件下每页的条数
           6.layout        显示分页的样式种类 全部显示
           7.total         数据的总数
         -->
        <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="queryInfo.pageNum"
              :page-sizes="[5, 10, 20, 40]"
              :page-size="queryInfo.pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
        </el-pagination>

      </el-card>

      <!--
        :visible.sync  控制对话框是否展现
      -->
      <el-dialog title="用户新增" :visible.sync="addUserDialogVisible" width="65%"
          @close="closeAddUserDialog">

        <el-form :model="addUserForm" :rules="rules" ref="addUserRuleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="addUserForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="addUserForm.password" type="password"></el-input>
          </el-form-item>
          <el-form-item label="密码确认" prop="password2">
            <el-input v-model="addUserForm.password2" type="password"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="addUserForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="addUserForm.email"></el-input>
          </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
          <el-button @click="addUserDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addUserBtn">确 定</el-button>
        </span>
      </el-dialog>


  </div>
</template>

<script>
  export default {
    data(){

      //自定义校验规则 rule:当前规则对象一般不用  value: 当前校验的数据  callback:回调函数
      //校验邮箱规则
      const checkEmail = (rule, value, callback) => {
        //定义邮箱的正则表达式  JS中用/来表示正则表达式的开始和结束
        const emailRege = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9-_]+\.[a-zA-Z0-9-_]+$/
        if (emailRege.test(value)) {
          //表示邮箱合法 正确返回  通过返回true   失败返回false
          return callback() //自定义规则执行成功,之后后续操作
        }
        callback(new Error('请填写正确的邮箱地址'))
      }

      //校验手机号的邮箱规则
      const checkPhone = (rule, value, callback) => {

        //定义校验手机号的正则语法
        const phoneRege = /^1[3456789][0-9]{9}$/
        if (phoneRege.test(value)) {

          return callback()
        }
        callback(new Error('请填写正确的手机号'))

      }

      //密码确认  判断与password是否相同
      const checkPassword = (rule, value, callback) => {

        if(value !== this.addUserForm.password){
           return callback(new Error('2次密码填写不一致'))
        }
        //如果相同,则调用回调函数
        callback()
      }

      return {
        //定义分页查询对象
        queryInfo: {
          query: '',    //用户查询的数据
          pageNum: 1,   //默认第一页
          pageSize: 5   //每页5条
        },
        userList: [],   //获取分页后的结果
        total: 0,
        addUserDialogVisible: false,
        //设定新增用户的对象
        addUserForm: {
          username: '',
          password: '',
          password2:  '',
          phone:  '',
          email:  ''
        },
        rules: {
           username: [
                      { required: true, message: '请输入用户名', trigger: 'blur' },
                      { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' }
                    ],
           password: [
                      { required: true, message: '请输入密码', trigger: 'blur' },
                      { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' }
                    ],
           password2: [
                      { required: true, message: '请输入密码', trigger: 'blur' },
                      { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' },
                      { validator: checkPassword, trigger: 'blur' }
                    ],
           phone: [
                      { required: true, message: '请输入电话', trigger: 'blur' },
                      { min: 11, max: 11, message: '长度必须11个字符', trigger: 'blur' },
                      { validator: checkPhone, trigger: 'blur' }
                    ],
           email: [
                      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                      { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' },
                      { validator: checkEmail, trigger: 'blur' }
                    ]
        }
      }
    },
    methods: {
      //1.动态获取userList数据
      async getUserList(){
       const {data: result} = await this.$http.get("/user/list",{params: this.queryInfo})
       if(result.status !== 200) return this.$message.error("获取列表失败")
       //为total属性赋值
       this.total = result.data.total
       this.userList = result.data.rows
      },
      handleSizeChange(pageSize){
        //查询的条件需要变化
        this.queryInfo.pageSize = pageSize
        //重新查询数据
        this.getUserList()
      },
      handleCurrentChange(pageNum){
        this.queryInfo.pageNum = pageNum
        this.getUserList()
      },
      async updateStatus(user){
        //获取用户的Id号/状态信息 发起restFul请求.
        //this.$http.put("/user/status/"+user.id+"/"+user.status)
        //模板字符串写法 `` 可以编辑多行,可以直接对象取值${key}
        //es6的高端写法
        const {data: result} =
        await this.$http.put(`/user/status/${user.id}/${user.status}`)
        if(result.status !== 200) return this.$message.error("更新操作失败")
        this.$message.success("更新操作成功!")
      },
      closeAddUserDialog(){
        //当对话框关闭时,应该重置表单
        this.$refs.addUserRuleForm.resetFields()
      },
      addUserBtn(){
        //对整个表单重新进行校验  1.获取表单的对象  2.进行数据校验
        this.$refs.addUserRuleForm.validate(async valid => {
          if(!valid) return this.$message.error("请正确填写数据")
          //之后发起ajax请求实现用户新增
          const {data: result} = await this.$http.post('/user/addUser',this.addUserForm)
          if(result.status !== 200) return this.$message.error("新增用户失败")
          this.$message.success("新增用户成功")
          //将对话框关闭
          this.addUserDialogVisible = false
          //重新刷新列表页面
          this.getUserList()
        })

      },
      async deleteUser(user){
        //定义消息确认框  promise对象 如果从中获取用户的选项 不方便
      const  result = await this.$confirm('此操作将永久删除'+user.username+', 是否继续?', '提示', {
                 confirmButtonText: '确定',
                 cancelButtonText: '取消',
                 type: 'warning'
      }).catch(error=>error)
      //确定:confirm  取消 cancel
      if(result !=='confirm') return this.$message.info("用户取消操作")

        const {data: resultDB} = await this.$http.delete('/user/'+user.id)
          if(resultDB.status !==200) return this.$message.error("用户删除失败")
          this.$message.success("用户删除成功")
          //重新加载用户列表
          this.getUserList()

       }
      },
    //当页面加载完成之后 调用该函数
    mounted(){
      //获取userList列表数据
      this.getUserList()
    }
  }
</script>

<!--
  当前样式是否支持less语法 样式的一种语言
  scoped 让样式只对当前组件有效 防止样式击穿
 -->
<style lang="less" scoped>

</style>
