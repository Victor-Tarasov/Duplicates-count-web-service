package duplicate.counter;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author Victor Tarasov
 */
//curl -i  -X POST -H "Content-Type: multipart/form-data"  -F "file=@/tmp/testFile.txt"  -F "file=@/tmp/secondTestFile.txt"   http://localhost:8080/load
@Controller
public class DuplicateCounterController {

	@Autowired
	private FileProcessor fileProcessor;

	@ResponseBody
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public String saveFile(@RequestParam("file") List<MultipartFile> file) throws IOException {
		return "Test sfsdsdfsdf";
	}
}
