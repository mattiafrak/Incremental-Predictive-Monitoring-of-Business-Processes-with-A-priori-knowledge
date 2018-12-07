"""
This file was created to manage running of experiments.

## settings are in the shared variables file
"""


from inference_algorithms import _6_evaluate_baseline_SUFFIX_only
from inference_algorithms import _11_cycl_pro_SUFFIX_only

from inference_algorithms import _6_evaluate_baseline_SUFFIX_and_group
from inference_algorithms import _11_cycl_pro_SUFFIX_resource_LTL
from inference_algorithms import _11_cycl_pro_SUFFIX_declare_smart_queue

from inference_algorithms import _6_evaluate_baseline_SUFFIX_group_and_elapsed_time

from shared_variables import activate_settings, eventlog
from train import train
from train_with_data import train_with_data
from train_with_data_and_time import train_with_data_and_time
from train_resource_only import train_resource_only
from train_time_only import train_time_only

#formula_used = "WEAK"
formula_used = "STRONG"
logNumber = 10

#train()
#train_with_data()
train_with_data_and_time()
#train_resource_only()
#train_time_only()

# CF stands for Control Flow
# CFR stands for Control Flow + Resource
# CFRT stands fro Control Flow + Resource + elapsed Time
# They indicate which RNN model should be used for the inference algorithm

#_6_evaluate_baseline_SUFFIX_only.run_experiments(logNumber, formula_used, "CF")
#_11_cycl_pro_SUFFIX_only.run_experiments(logNumber, formula_used, "CF")

#_6_evaluate_baseline_SUFFIX_and_group.run_experiments(logNumber, formula_used, "CFR")
#_11_cycl_pro_SUFFIX_resource_LTL.run_experiments(logNumber, formula_used, "CFR")
#_11_cycl_pro_SUFFIX_declare_smart_queue.run_experiments(logNumber, formula_used, "CFR")

#_6_evaluate_baseline_SUFFIX_group_and_elapsed_time.run_experiments(logNumber, formula_used, "CFRT")

