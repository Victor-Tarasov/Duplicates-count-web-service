package duplicate.counte;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Victor Tarasov
 */
@RestController
public class FileConsumer {

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public String saveFile() {
		return "Test sfsdsdfsdf";
	}
}
