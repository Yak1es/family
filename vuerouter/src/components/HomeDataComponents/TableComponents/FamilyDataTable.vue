<template>
    <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%"
            :header-cell-style="{background:'#eeeff4',color:'#5d5e5e',fontSize:'14px',fontWeight:' normal',textTransform: 'uppercase'}"


    >
        <el-table-column label="Id" prop="id" width="150px" align="center"></el-table-column>
        <el-table-column label="Date" prop="date" width="150px" align="center"></el-table-column>
        <el-table-column label="Member" prop="name" width="150px" align="center"></el-table-column>

        <el-table-column label="Info" prop="Info" width="150px" align="center"></el-table-column>
        <el-table-column label="Money" prop="money" width="150px" align="center"></el-table-column>
        <el-table-column label="Type" prop="type" width="150px" align="center"></el-table-column>

        <el-table-column label="Name" prop="name" width="150px" align="center"></el-table-column>
        <el-table-column label="Address" prop="address"   align="center"></el-table-column>
    </el-table>

</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '2016-05-02',
          name: '父亲',
          address: '上海市普陀区金沙江路 1518 弄',
          Info:'吃饭',
          type:'支出',
          money:10,
        }, {
          date: '2016-05-04',
          name: '母亲',
          address: '上海市普陀区金沙江路 1517 弄',
          Info:'买菜',
          type:'支出',
          money:30,
        }, {
          date: '2016-05-01',
          name: '父亲',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '孩子',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        search: ''
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
  }

</script>
<style scoped>
    .has-gutter {
        color: #00c292;
    }
</style>