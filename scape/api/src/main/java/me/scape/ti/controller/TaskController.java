package me.scape.ti.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.scape.ti.result.Result;
import me.scape.ti.result.ResultCode;
import me.scape.ti.ro.ApplyTaskRequest;
import me.scape.ti.ro.PrivilegedPageRequest;
import me.scape.ti.ro.PublishTaskRequest;
import me.scape.ti.ro.TaskSearchRequest;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午2:36:45
 */
@Controller("taskController")
@RequestMapping(value = "/task")
public class TaskController extends BaseController {
	
	@RequestMapping(value = "/search", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> search(@Valid TaskSearchRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = taskService.search(request);
		return toResponse(result);
	}
	
	@RequestMapping(value = "/publish", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> publish(@Valid PublishTaskRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = taskService.publishTask(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/apply", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> apply(@Valid ApplyTaskRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = taskService.applyTask(request);
		return toResponse(result);
	}

	@RequestMapping(value = "/detail/{taskId}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> detail(@PathVariable Long taskId) {
		Result result = taskService.getTaskDetail(taskId);
		return toResponse(result);
	}

	@RequestMapping(value = "/apply_task", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> my_apply_task(@Valid PrivilegedPageRequest request, BindingResult validResult) {
		if (validResult.hasErrors()) {
			return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
		}
		Result result = taskService.myApplyTask(request);
		return toResponse(result);
	}

    @RequestMapping(value = "/publish_task", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> my_publish_task(@Valid PrivilegedPageRequest request, BindingResult validResult) {
        if (validResult.hasErrors()) {
            return toResponse(Result.newError().with(ResultCode.Error_Valid_Request));
        }
        Result result = taskService.myPublishTask(request);
        return toResponse(result);
    }
}