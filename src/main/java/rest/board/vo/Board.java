package rest.board.vo;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {

	private Long id;
	@NotEmpty
	private String title;
	private String content;
	private LocalDateTime reg_date;
	private Long m_id;
	private MultipartFile file1;
	private String file1Name;
	private String file1SName;
	private String email;
	private LocalDateTime update_date;
	private int pageIndex;
	private int perPageCount;
}
