package demo.controller;

import demo.mapper.CSGOMapper;
import demo.model.CSGO_team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/CS:GO")
public class csgoController {
    @Autowired
    private CSGOMapper csgoMapper;


//    查询所有队伍数据
    @RequestMapping("/getCSGOTeam")
    public List<CSGO_team> getCSGOTeam(){
        List csgo_team = csgoMapper.selectList(null);
        return csgo_team;
    }

//    条件查询：通过id查询队伍信息
    @RequestMapping("/getCSGOTeamById")
    public CSGO_team getCSGOTeamById(int id){
        if(id >0 && id <= csgoMapper.selectCount(null)){
            CSGO_team csgo_team = csgoMapper.selectById(id);
            return csgo_team ;
        }
        CSGO_team csgo_team1 = new CSGO_team();
        return csgo_team1;
    }

//    修改队伍数据
    @RequestMapping("/updateCSGOTeam")
    public CSGO_team updateCSGOTeam(@RequestBody CSGO_team csgo_team){
        if(csgoMapper.updateById(csgo_team)>0) {
            return csgo_team ;
        }else {
            CSGO_team csgo_team1 = new CSGO_team();
            return csgo_team1 ;
        }
    }

//    删除队伍数据
    @RequestMapping("/deleteCSGOTeam")
    public String deleteCSGOTeam(int id){
        if(id<=0 && id>csgoMapper.selectCount(null)) {
            return "删除失败";
        }else {
            csgoMapper.deleteById(id);
            return "删除成功";
        }
    }

//    添加队伍数据
    @RequestMapping("/insertCSGOTeam")
    public CSGO_team insertCSGOTeam(@RequestBody CSGO_team csgo_team){
        if( csgo_team.getId() >csgoMapper.selectCount(null)&& csgo_team.getId() < (csgoMapper.selectCount(null)+2)) {
            csgoMapper.insert(csgo_team);
            return csgo_team;
        }else {
            CSGO_team csgo_team1 = new CSGO_team();
            return csgo_team1;
        }
    }
}
