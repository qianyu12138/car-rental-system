package cn.yd.carrentalsystem.controller;

import cn.yd.carrentalsystem.fastdfs.FastDFSClient;
import cn.yd.carrentalsystem.po.*;
import cn.yd.carrentalsystem.service.KindService;
import cn.yd.carrentalsystem.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class SystemController {

    @Value("${Host}")
    private String host;
    @Autowired
    private SystemService systemService;
    @Autowired
    private KindService kindService;

    @RequestMapping("/findCarAll")
    public String findCarAll(HttpServletRequest request, CarQueryVo carQueryVo, @RequestParam(value="pc",required=true,defaultValue="1") Integer pc)throws Exception{

        Integer ps = 2;
        PageBean<Car> pageBean = systemService.findCarAll(pc,ps,carQueryVo);
        request.setAttribute("pageBean", pageBean);
        return "system/carList";
    }
    @RequestMapping("/findCar")
    public String findCar(HttpServletRequest request, CarQueryVo carQueryVo, @RequestParam(value="pc",required=true,defaultValue="1") Integer pc)throws Exception{

        Integer ps = 2;
        PageBean<Car> pageBean = systemService.findCar(pc,ps,carQueryVo);
        request.setAttribute("pageBean", pageBean);
        //查询数据表获取所有商品信息

        return "system/carList";
    }

    //删除商品
    @RequestMapping("/deleteCar")
    public String deleteCar(Model model, @RequestParam(value="car_cid",required=true,defaultValue="1") Integer cid) throws Exception{

        Car car = systemService.findCarById(cid);
        model.addAttribute("car", car);
        systemService.deleteCar(car);

        return "redirect:findCarAll";//重定向到查询列表方法
    }


    @RequestMapping("toUpdateCar")
    public String toUpdateCar(HttpServletRequest request,Model model,@RequestParam(value="car_cid",required=true,defaultValue="1") Integer cid) throws Exception{

        //查询商品
        Car car = systemService.findCarById(cid);
        model.addAttribute("car", car);//将商品信息存入域中
        String carimg[]=car.getImgs().split(";");
        request.setAttribute("carimg1",host+carimg[0]);
        request.setAttribute("carimg2",host+carimg[1]);
        request.setAttribute("carimg3",host+carimg[2]);
        return "system/editCar";
    }
    //修改信息
    @RequestMapping("/editCar")
    public String editCar(@Validated Car car) throws Exception{
        systemService.editCar(car);
        return "redirect:findCarAll";//重定向到查询列表方法
    }

    @RequestMapping("toAddCar")
    public String toAddCar(Model model,@RequestParam(value="car_cid",required=true,defaultValue="1") Integer cid) throws Exception{
        List<Kind> kinds = kindService.getAllKinds();
        model.addAttribute("kinds", kinds);
        return "system/addCar";
    }
    //增加车辆
    @RequestMapping("/addCar")
    public String addCar(HttpServletRequest request, MultipartFile carimg1, MultipartFile carimg2,
                         MultipartFile carimg3,@Validated Car car ) throws Exception{
            systemService.addCar(car);
            String originalFilename1 =carimg1.getOriginalFilename();
            String originalFilename2=carimg2.getOriginalFilename();
            String originalFilename3=carimg3.getOriginalFilename();
            String extName = originalFilename1.substring(originalFilename1.lastIndexOf(".") + 1);
            String extName1=originalFilename2.substring(originalFilename2.lastIndexOf(".") + 1);
            String extName2=originalFilename3.substring(originalFilename3.lastIndexOf(".") + 1);

            //2、创建一个FastDFS的客户端
            FastDFSClient fastDFSClient = null;

            fastDFSClient = new FastDFSClient("classpath:client.conf");
            //3、执行上传处理
            String carimg = fastDFSClient.uploadFile(carimg1.getBytes(), extName);
            carimg=carimg+";"+fastDFSClient.uploadFile(carimg2.getBytes(),extName1);
        carimg=carimg+";"+fastDFSClient.uploadFile(carimg2.getBytes(),extName2);
            System.out.println(carimg);
            car.setImgs(carimg);
            systemService.editCar(car);
            //4、拼接返回的url和ip地址，拼装成完整 的url
            request.getSession().setAttribute("car",car);

        return "redirect:findCarAll";//重定向到查询列表方法
    }

    @RequestMapping("/carimg")
    public  String  carimg(HttpServletRequest request,@RequestParam(value="car_cid",required=true,defaultValue="1") Integer cid) throws Exception {
            Car car =systemService.findCarById(cid);
            String carimg[]=car.getImgs().split(";");
            request.setAttribute("carimg1",host+carimg[0]);
            request.setAttribute("carimg2",host+carimg[1]);
            request.setAttribute("carimg3",host+carimg[2]);
            return "system/carimg";
    }

    @RequestMapping("/findUserAll")
    public String findUserAll(HttpServletRequest request, UserQueryVo userQueryVo, @RequestParam(value="pc",required=true,defaultValue="1") Integer pc)throws Exception{

        Integer ps = 2;
        PageBean<User> pageBean = systemService.findUserAll(pc,ps,userQueryVo);
        request.setAttribute("pageBean", pageBean);
        //查询数据表获取所有商品信息

        return "system/userList";
    }
    @RequestMapping("/findUser")
    public String findUser(HttpServletRequest request, UserQueryVo userQueryVo, @RequestParam(value="pc",required=true,defaultValue="1") Integer pc)throws Exception{

        Integer ps = 2;
        PageBean<User> pageBean = systemService.findUser(pc,ps,userQueryVo);
        request.setAttribute("pageBean", pageBean);
        //查询数据表获取所有商品信息

        return "system/userList";
    }

    //删除商品
    @RequestMapping("/deleteUser")
    public String deleteUser(Model model,@RequestParam(value="user_uid",required=true,defaultValue="1") Integer uid) throws Exception{

        User user = systemService.findUserById(uid);
        model.addAttribute("user", user);
        systemService.deleteUser(user);

        return "redirect:findUserAll";//重定向到查询列表方法
    }
    //激活
    @RequestMapping("/editstate")
    public String editstate(Model model,@RequestParam(value="user_uid",required=true,defaultValue="1") Integer uid)throws Exception{

        User user = systemService.findUserById(uid);
        model.addAttribute("user", user);
        systemService.editstate(user);

        return "redirect:findUserAll";
    }

    @RequestMapping("toUpdateUser")
    public String toUpdateItems(Model model,HttpServletRequest request,@RequestParam(value="user_uid",required=true,defaultValue="1") Integer uid) throws Exception{

        //查询商品
        User user = systemService.findUserById(uid);
        model.addAttribute("user", user);//将商品信息存入域中
        String idCard[]=user.getIdcardimgs().split(",");
        String driverCard[]=user.getLicenseiimg().split(",");
        request.setAttribute("idCard1",host+idCard[0]);
        request.setAttribute("idCard2",host+idCard[1]);
        request.setAttribute("driverCard1",host+driverCard[0]);
        request.setAttribute("driverCard2",host+driverCard[0]);
        return "system/editUser";
    }
    //修改信息
    @RequestMapping("/editUser")
    public String editItems(@Validated User user) throws Exception{
        systemService.editUser(user);
        return "redirect:findUserAll";//重定向到查询列表方法
    }
    @RequestMapping("/useridentitySAuth")
    public  String  useridentitySAuth(Model model,HttpServletRequest request,@RequestParam(value="user_uid",required=true,defaultValue="1") Integer uid) throws Exception {
        User user =systemService.findUserById(uid);
////        model.addAttribute("user", useri);
//        User user = (User) request.getSession().getAttribute("user");
        if (user.getState().equals("1"))
        {
            String idCard[]=user.getIdcardimgs().split(",");
            String driverCard[]=user.getLicenseiimg().split(",");
            request.setAttribute("idCard1",host+idCard[0]);
            request.setAttribute("idCard2",host+idCard[1]);
            request.setAttribute("driverCard1",host+driverCard[0]);
            request.setAttribute("driverCard2",host+driverCard[0]);
            return "system/showidentity";
        }
        else{
            return "system/authenticationAccountT";
        }
    }


    @RequestMapping("/findKindAll")
    public String findKindAll(HttpServletRequest request, KindQueryVo kindQueryVo, @RequestParam(value="pc",required=true,defaultValue="1") Integer pc)throws Exception{

        Integer ps = 5;
        PageBean<Kind> pageBean = systemService.findKindAll(pc,ps,kindQueryVo);
        request.setAttribute("pageBean", pageBean);
        return "system/kindList";
    }
    @RequestMapping("/findKind")
    public String findKind(HttpServletRequest request, KindQueryVo kindQueryVo, @RequestParam(value="pc",required=true,defaultValue="1") Integer pc)throws Exception{

        Integer ps = 5;
        PageBean<Kind> pageBean = systemService.findKind(pc,ps,kindQueryVo);
        request.setAttribute("pageBean", pageBean);
        //查询数据表获取所有商品信息

        return "system/kindList";
    }



    @RequestMapping("toUpdateKind")
    public String toUpdateKind(Model model,@RequestParam(value="kind_kid",required=true,defaultValue="1") Integer kid) throws Exception{

        //查询商品
        Kind kind = systemService.findKindById(kid);
        model.addAttribute("kind", kind);//将商品信息存入域中
        return "system/editKind";
    }
    //修改信息
    @RequestMapping("/editKind")
    public String editKind(@Validated Kind kind) throws Exception{
        systemService.editKind(kind);
        return "redirect:findKindAll";//重定向到查询列表方法
    }

    @RequestMapping("toAddKind")
    public String toAddKind(Model model) throws Exception{
        List<Kind> kinds = kindService.getAllKinds();
        model.addAttribute("kinds", kinds);
        return "system/addKind";
    }
    //增加车辆
    @RequestMapping("/addKind")
    public String addKind(@Validated Kind kind ) throws Exception{

        systemService.addKind(kind);
        return "redirect:findKindAll";//重定向到查询列表方法
    }
}
