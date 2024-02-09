package jp.co.trainocamp.demo.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.trainocamp.demo.mybatis.entity.User;

@Mapper
public interface UserMapper {

    /**
     * 全ユーザーを取得
     * 
     * @return 全ユーザーの情報
     * 
     */
    List<User> selectAll();
}