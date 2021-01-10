package au.usyd.elec5619.web;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import antlr.collections.List;
import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.service.ProductManager;
import au.usyd.elec5619.util.Constants;


@Controller
@RequestMapping(value="/product/**")
public class ProductController {
	
	@Resource(name="productManager")
	private ProductManager productManager;

	@RequestMapping(value="/add")
	public String addProduct(Model uiModel) {
		
		return "add";
	}
	
	@RequestMapping(value="/add1", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		System.out.println("addProduct");
		Product product = new Product();
		product.setDescription(httpServletRequest.getParameter("description"));
		product.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
//		product.setImage(httpServletRequest.getParameter("image"));
		this.productManager.addProduct(product);
		
		return "redirect:/hello.htm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id") Long id, Model uiModel) {
		
		Product product = this.productManager.getProductById(id);
		uiModel.addAttribute("product", product);
		
		return "edit";
	}
	
	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editProduct(@Valid Product product) {
		
		this.productManager.updateProduct(product);
		System.out.println(product.getId());
		
		return "redirect:/hello.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long id) {
		
		this.productManager.deleteProduct(id);

		return "redirect:/hello.htm";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchProduct(Model model, HttpServletRequest httpServletRequest) {
		String desp = httpServletRequest.getParameter("description");
		
//		this.productManager.getProducts(desp);
		model.addAttribute("lists",this.productManager.getProducts(desp));
		return "search";
		
	}
	
	@RequestMapping(value="/registerProduct", method = RequestMethod.GET)
	public String register(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "product/register";
	}
	/*
	@RequestMapping(value="/showItem", method = RequestMethod.GET)
	public String showItem(Model model){
		
		return "showItem";
	}*/
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doRegister(Product product,@RequestParam("imgFile") MultipartFile file,
            Model model){
//		System.out.println("doRegister");
//		Product product = new Product();
//		product.setDescription(httpServletRequest.getParameter("description"));
//		product.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		if (this.productManager.addProduct(product, file)){
            model.addAttribute("product", product);
            return "redirect:/hello.htm"; // 注册成功，跳转到显示页面
        }
        return "/product/add";
	}
	
	@RequestMapping("/showPic/{fileName}.{suffix}")
    public void showPicture(@PathVariable("fileName") String fileName,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response){
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        System.out.println(imgFile.getPath());
        responseFile(response, imgFile);
    }
	
	@RequestMapping("/downloadPic/{fileName}.{suffix}")
    public void downloadPicture(@PathVariable("fileName") String fileName,
                                @PathVariable("suffix") String suffix,
                                HttpServletResponse response){
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + "headPic.jpg");
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        responseFile(response, imgFile);
    }
	
	private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

	
		
}
