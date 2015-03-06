package me.scape.ti.controller;

import me.scape.ti.service.ContestService;
import me.scape.ti.vo.ContestDetailNewsVO;
import me.scape.ti.vo.ContestDetailVO;
import me.scape.ti.vo.ContestListVO;
import me.scape.ti.vo.ContestNewsListVO;
import me.scape.ti.vo.CurrentPage;
import me.scape.ti.vo.request.ContestListRequest;
import me.scape.ti.vo.request.ContestNewsListRequest;
import me.scape.ti.vo.request.ContestNewsRequest;
import me.scape.ti.vo.request.ContestRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContestController extends BaseController {

    @Autowired
    private ContestService contestService;

    @RequestMapping("/contest/list")
    public String listContests(@ModelAttribute ContestListRequest contestListRequest, Model model) {

        CurrentPage<ContestListVO> result = contestService.listContests(contestListRequest);
        model.addAttribute("curn", result.getCurn());
        model.addAttribute("totaln", result.getTotaln());
        model.addAttribute("contests", result.getItems());
        model.addAttribute("ps", contestListRequest.getPs());

        model.addAttribute("request", contestListRequest);

        StringBuilder condition = new StringBuilder();
        if (null != contestListRequest.getStatus()) {
            condition.append("&status=").append(contestListRequest.getStatus());
        }
        if (StringUtils.isNotEmpty(contestListRequest.getTitle())) {
            condition.append("&name=").append(contestListRequest.getTitle());
        }

        model.addAttribute("condition", condition.toString());

        return "contest/list";
    }

    @RequestMapping("/contest/addPage")
    public String getAddContestPage(Model model) {
        model.addAttribute("contest", new ContestDetailVO());

        return "contest/form";
    }

    @RequestMapping(value = "/contest/add", method = RequestMethod.POST)
    public String addContest(@ModelAttribute ContestRequest contestRequest, Model model) {
        contestService.createContest(contestRequest);

        return "redirect:/contest/list";
    }

    @RequestMapping("/contest/editPage")
    public String getEditContestPage(int contestId, Model model) {
        model.addAttribute("contest", contestService.getContestDetail(contestId));

        return "contest/form";
    }

    @RequestMapping(value = "/contest/edit", method = RequestMethod.POST)
    public String editContest(int id, @ModelAttribute ContestRequest contestRequest) {
        contestService.editContest(id, contestRequest);

        return "redirect:/contest/list";
    }

    @RequestMapping("/contest_news/list")
    public String listContestNews(@ModelAttribute ContestNewsListRequest contestNewsListRequest, Model model) {

        CurrentPage<ContestNewsListVO> result = contestService.listContestNews(contestNewsListRequest);
        model.addAttribute("curn", result.getCurn());
        model.addAttribute("totaln", result.getTotaln());
        model.addAttribute("news_list", result.getItems());
        model.addAttribute("ps", contestNewsListRequest.getPs());

        model.addAttribute("request", contestNewsListRequest);

        StringBuilder condition = new StringBuilder();
        model.addAttribute("condition", condition.toString());

        return "contest/news_list";
    }

    @RequestMapping("/contest_news/addPage")
    public String getAddContestNewsPage(Model model) {
        model.addAttribute("contest_news", new ContestDetailNewsVO());
        model.addAttribute("contests", contestService.listAllEnabledContests());

        return "contest/news_form";
    }

    @RequestMapping(value = "/contest_news/add", method = RequestMethod.POST)
    public String addContestNews(@ModelAttribute ContestNewsRequest contestNewsRequest, Model model) {
        contestService.createContestNews(contestNewsRequest);

        return "redirect:/contest_news/list";
    }

    @RequestMapping("/contest_news/editPage")
    public String getEditContestNewsPage(long id, Model model) {
        model.addAttribute("contest_news", contestService.getContestNewsDetail(id));
        model.addAttribute("contests", contestService.listAllEnabledContests());

        return "contest/news_form";
    }

    @RequestMapping(value = "/contest_news/edit", method = RequestMethod.POST)
    public String editContestNews(long id, @ModelAttribute ContestNewsRequest contestNewsRequest) {
        contestService.editContestNews(id, contestNewsRequest);

        return "redirect:/contest_news/list";
    }
}
