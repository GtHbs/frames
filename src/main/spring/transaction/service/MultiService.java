package spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李昭
 */
@SuppressWarnings("all")
@Service
public class MultiService {

    @Qualifier("bookService")
    @Autowired
    BookService service;

    /**
     * required表示当前事务和事务内的两个事务共用当前事务,一个发生异常全部回滚
     * 如果下面的事务重新启动事务且发生异常,会将异常返给上面的事务,造成全部回滚
     *  multi() {
     *      //required
     *      A() {
     *          //requires_new
     *          B(){}
     *          //required
     *          C(){}
     *      }
     *      //requires_new
     *      D(){
     *          DDD();  //required崩,requires_new成功
     *          //required
     *          E(){
     *              //requires_new
     *              F(){
     *                  10 / 0;(F,E,G,D,A,C,Multi崩,B成功)因为异常会向上反
     *              }
     *          }
     *          //requires_new
     *          G(){}
     *      }
     *      10 / 0;(B成功,D内全部成功)
     *      已经执行的requires_new都会成功
     *  }
     */
    @Transactional
    public void multi() {
        //子事务中的timeout属性不起作用,由主事务管理
        service.checkOut("alone","001");
        service.updatePrice("001",200);
        int i = 10 / 0;
    }
}
