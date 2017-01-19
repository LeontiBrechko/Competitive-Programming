import requests
import random
import argparse


def get_chapter_tasks(chapters):
    chapters_to_include = chapters
    chapters_json = requests.get('http://uhunt.felix-halim.net/api/cpbook/3').json()
    chapters = [chapters_json[x - 1] for x in chapters_to_include]
    tasks = [sub_sub_chapter for chapter in chapters for sub_chapter in chapter['arr'] for sub_sub_chapter in
             sub_chapter['arr']]
    tasks = filter(lambda t: type(t) == int, [task for array in tasks for task in array])
    tasks = map(lambda t: -t if t < 0 else t, tasks)
    return tasks


def get_user_submissions(username):
    user_id = int(requests.get('http://uhunt.felix-halim.net/api/uname2uid/{0}'.format(username)).text)
    pids = set([sub[1] for sub in
                requests.get('http://uhunt.felix-halim.net/api/subs-user/{0}'.format(user_id)).json()['subs']])
    print username
    print user_id
    return pids


def get_next_task_to_solve(tasks, pids):
    random.shuffle(tasks)
    while True:
        for i in xrange(1, 100):
            task_index = random.randint(0, len(tasks) - 1)
        next_pid = requests.get('http://uhunt.felix-halim.net/api/p/num/{0}'.format(tasks[task_index])).json()['pid']
        if next_pid in pids:
            del tasks[task_index]
        else:
            return tasks[task_index]


def handle_arguments():
    parser = argparse.ArgumentParser(description='Generate the next task to solve on UVa from textbook (3rd edition)')
    parser.add_argument('username', action='store', nargs=1, type=str,
                        help='username of profile to generate next unsolved task')
    parser.add_argument('--cns', action='store', nargs='*', default=range(1, 10),
                        type=int, required=False,
                        help='number of chapters to generate tasks from')
    return parser.parse_args()


args = handle_arguments()
chapter_tasks = get_chapter_tasks(args.cns)
user_pids = get_user_submissions(args.username[0])
print 'Next task to solve: {0}'.format(get_next_task_to_solve(chapter_tasks, user_pids))
