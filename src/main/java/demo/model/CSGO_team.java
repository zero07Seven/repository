package demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("team_ranking")
public class CSGO_team {
    private int id ;
    private String team;
    private String maps;
    private String kd;
    private String points;
    private String img;
}
