package qin.hu.request;

/**
 * @ProjectName: QinHU_Ticket
 * @Package: qin.hu.request
 * @ClassName: Api
 * @CreateDate: 2019/11/8 0008 16:20
 * @Description:
 * @Version: 1.0
 */

public class Api {

    public static String URL = "http://112.4.100.93:31018" ;

    /*
     * 获取选票的数据
     * POST JSON
     * param         terminal_id 默认12
     * param         note_classification 散客票为1 ; 团队票为2 ;
     * param         flag 默认为0
     * return        TakeTicket
     * */
    public static String TAKETICKET ="/notetype/selflist";

    /*
     * 生成订单
     * POST
     * type          订单类型（1：商城  2：门票）
     * total_price   购买总价格
     * num           购买总数量
     * goods_ids     商品或门票票种id 用 ， 隔开
     * goods_nums    商品或门票对应数量 用 ， 隔开
     * buy_from      渠道来源 0：小程序 1：普通售票处 2：自助售票处
     * print_type    打印方式 1：多人一票 2：一人一票
     * idcard_id     身份证id
     * partner_id    景区id
     * use_time      使用时间
     * return        Order
     * */
    public static String ORDER = "/commonOrder/addOrder";

    public static String ORDER_PAY = "/commonOrder/orderPay";

    public static String GET_VALIDCODE = "/notetype/getValidCode";

    public static String VALIDATECODE = "/notetype/validateCode";

    public static String ADDFACECONFIG = "/notetype/addFaceConfig";

    public static String QUERYFACECONFIGBYPHOE = "/notetype/queryfaceConfigByPhone";

    public static String deleteFaceConfigByOrderno = "/notetype/deleteFaceConfigByOrderno";

    /*
     * 获取打印的数据
     * POST
     * param         qr_code 订单返回的二维码
     * return        PrintTicket
     * */
    public static String PRINTTICKETINFO = "/commonOrder/printTicketInfo";

    /*
     * 根据id查询订单信息
     * POST
     * param         id 订单的id
     * return        OrderInfo
     * */
    public static String QUERYRODERINFOBID = "/commonOrder/queryOrderById";

    /*
     * 获取当前合作方的数据
     * POST
     * param          sight_name 模糊搜索字段
     * return         SigntList
     * */
    public static String QUERYSIGHTLIST = "/notetype/querySightList";

    /*
     * 返回是否需要身份证
     * GET
     * param          id 合作方id/partner_id
     * return         partnerInfo 的 iscard  0 不要求身份证
     *                               1 强制要求身份证
     * */
    public static String PARTNER = "/partner/info";

    public static String Face = "/notetype/addFaceConfigByOrder";

}
