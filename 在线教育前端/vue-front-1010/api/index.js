import request from '@/utils/request'
export default {
  //查询两条banner信息
  getIndexData() {
    return request({
      url: `/eduservice/indexfront/index`,
      method: 'get'
    })
  }

}